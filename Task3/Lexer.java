import java.util.ArrayList;

class Lexer 
{
	public static ArrayList<ArrayList<Token>> TokenizeFile(ArrayList<String> file) 
	{
		ArrayList<ArrayList<Token>> output = new ArrayList<ArrayList<Token>>();
		int scope = 0;

		for (int i = 0; i < file.size(); i++) {
			output.add(convertLine(file.get(i), scope));

			Token topPointer = output.get(i).get(0);

			if (topPointer.Type == "Control" && (topPointer.Value == "while" || topPointer.Value == "if")) {
				scope += 1;
			} else if (topPointer.Type == "Control" && topPointer.Value == "end") {
				scope -= 1;
			}
		}
		return output;
	}

	private static int getPointerToBracketBreak(String line) 
	{
		int bracketcount = 0;
		int pointer = 0;

		do {
			if (line.substring(pointer, pointer + 1).equals("(")) {
				bracketcount += 1;
			} else if (line.substring(pointer, pointer + 1).equals(")")) {
				bracketcount -= 1;
			}
			pointer += 1;
		} while (bracketcount > 0);

		return pointer;
	}

	private static ArrayList<Token> convertLine(String line, int scope) 
	{
		ArrayList<Token> output = new ArrayList<Token>();

		if (line.substring(0, 3).equals("end")) {
			output.add(new Token("Control", "end", scope));
		} else if (line.substring(0, 5).equals("break")) {
			output.add(new Token("Control", "break", scope));
		} else if (line.substring(0, 2).equals("if")) {
			output.add(new Token("Control", "if", scope));
			output.addAll(convertLogicFunction(line.substring(4, line.length() - 1), scope));
		} else if (line.substring(0, 5).equals("while")) {
			output.add(new Token("Control", "while", scope));
			output.addAll(convertLogicFunction(line.substring(7, line.length() - 1), scope));
		} else {
			String[] parts = line.split(" = ");

			output.add(new Token("Assignment", "=", scope));
			output.add(new Token("Var", parts[0], scope));
			output.addAll(convertMathsFunction(parts[1], scope));
		}
		return output;
	}

	private static ArrayList<Token> convertLogicFunction(String line, int scope) 
	{
		ArrayList<Token> output = new ArrayList<Token>();

		if (line.substring(0, 3).equals("not")) {
			output.add(new Token("LogicFunction", "not", scope));
			output.add(new Token("Temporary", "(", scope));
			output.addAll(convertLogicFunction(line.substring(5, line.length() - 1), scope));
			output.add(new Token("Temporary", ")", scope));
		} else {
			int pointer = getPointerToBracketBreak(line);

			if (pointer == 1) {
				output.addAll(convertBoolFunction(line, scope));
			} else if (line.substring(pointer + 1, pointer + 4).equals("and")) {
				output.add(new Token("LogicFunction", "and", scope));

				String[] parts = line.split(" and ");
				output.add(new Token("Temporary", "(", scope));
				output.addAll(convertLogicFunction(parts[0].substring(1, parts[0].length() - 1), scope));
				output.add(new Token("Temporary", ")", scope));
				output.add(new Token("Temporary", "(", scope));
				output.addAll(convertLogicFunction(parts[1].substring(1, parts[1].length() - 1), scope));
				output.add(new Token("Temporary", ")", scope));
			} else {
				output.add(new Token("LogicFunction", "or", scope));

				String[] parts = line.split(" or ");
				output.add(new Token("Temporary", "(", scope));
				output.addAll(convertLogicFunction(parts[0].substring(1, parts[0].length() - 1), scope));
				output.add(new Token("Temporary", ")", scope));
				output.add(new Token("Temporary", "(", scope));
				output.addAll(convertLogicFunction(parts[1].substring(1, parts[1].length() - 1), scope));
				output.add(new Token("Temporary", ")", scope));
			}
		}
		return output;
	}

	private static ArrayList<Token> convertBoolFunction(String line, int scope) 
	{
		ArrayList<Token> output = new ArrayList<Token>();
		int pointer = getPointerToBracketBreak(line);

		if (pointer == 1) {
			output.add(new Token("BoolLiteral", line, scope));
		} else {
			output.add(new Token("BoolFunction", line.substring(pointer + 1, pointer + 3), scope));
			
			String[] parts = line.split(line.substring(pointer, pointer + 4));
			
			output.add(new Token("Temporary", "(", scope));
			output.add(new Token("Var", parts[0], scope));
			output.add(new Token("Temporary", ")", scope));
			output.add(new Token("Temporary", "(", scope));
			output.add(new Token("Var", parts[1], scope));
			output.add(new Token("Temporary", ")", scope));
		}
		return output;
	}

	private static ArrayList<Token> convertMathsFunction(String line, int scope) 
	{
		ArrayList<Token> output = new ArrayList<Token>();
		int pointer = getPointerToBracketBreak(line);

		System.out.println(line + " : " + pointer);
		System.out.println(line.substring(pointer + 1, pointer + 2));

		if (pointer == 1) {
			output.add(new Token("Var", line, scope));
		} else {
			output.add(new Token("MathsFunction", line.substring(pointer + 1, pointer + 2), scope));
			
			String[] parts = line.split(line.substring(pointer, pointer + 3));
			
			System.out.println(parts[0]);
			System.out.println(parts[1]);

			output.add(new Token("Temporary", "(", scope));
			output.addAll(convertMathsFunction(parts[0], scope));
			output.add(new Token("Temporary", ")", scope));
			output.add(new Token("Temporary", "(", scope));
			output.addAll(convertMathsFunction(parts[1], scope));
			output.add(new Token("Temporary", ")", scope));
		}
		return output;
	}
}