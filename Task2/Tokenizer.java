import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Tokenizer 
{
	public static ArrayList<Token> TokenizeFile(ArrayList<String> InputLines) 
	{
		ArrayList<Token> output = new ArrayList<Token>();
		int ScopeCount = 0;

		for (int i = 0; i < InputLines.size(); i++) {
			output.add(TokenizeLine(InputLines.get(i), ScopeCount));

			if (output.get(output.size() - 1).Opcode == "not") {
				ScopeCount += 1;
			} else if (output.get(output.size() - 1).Opcode == "end") {
				ScopeCount -= 1;
			}
		}
		return output;
	}

	private static Token TokenizeLine(String Line, int Scope) 
	{
		//System.out.println(Line);
		Pattern incrReg = Pattern.compile("incr\\s[a-zA-Z]+[a-zA-Z0-9]*\\s?[0-9]*;");
		Pattern decrReg = Pattern.compile("decr\\s[a-zA-Z]+[a-zA-Z0-9]*\\s?[0-9]*;");
		Pattern clearReg = Pattern.compile("clear\\s[a-zA-Z]+[a-zA-Z0-9]*;");
		Pattern notReg = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*\\s not \\s?[0-9]*");
		Pattern whiledoReg = Pattern.compile("while\\s[a-zA-Z0-9\\s]*\\sdo;");
		Pattern endReg = Pattern.compile("end;");

		Matcher incrMatch = incrReg.matcher(Line);
		Matcher decrMatch = decrReg.matcher(Line);
		Matcher clearMatch = clearReg.matcher(Line);
		Matcher notMatch = notReg.matcher(Line);
		Matcher whiledoMatch = whiledoReg.matcher(Line);
		Matcher endMatch = endReg.matcher(Line);

		if (incrMatch.matches()) {
			//System.out.println(Scope);
			Line = Line.substring(5, Line.length() - 1);
			String[] parts = Line.split(" ");

			if (parts.length == 1) {
				return new Token("incr", parts[0], 1);
			} else {
				return new Token("incr", parts[0], Integer.parseInt(parts[1]));
			}
		} else if (decrMatch.matches()) {
			//System.out.println(Scope);
			Line = Line.substring(5, Line.length() - 1);
			String[] parts = Line.split(" ");

			if (parts.length == 1) {
				return new Token("decr", parts[0], 1);
			} else {
				return new Token("decr", parts[0], Integer.parseInt(parts[1]));
			}
		} else if (clearMatch.matches()) {
			//System.out.println(Scope);
			Line = Line.substring(6, Line.length() - 1);

			return new Token("clear", Line);
		} else if (whiledoMatch.matches()) {
			//System.out.println(Scope + 1);
			Line = Line.substring(6, Line.length() - 4);
			String[] parts = Line.split(" not ");

			return new Token("not", parts[0], Integer.parseInt(parts[1]), Scope + 1);
		} else if (endMatch.matches()) {
			//System.out.println(Scope);
			return new Token("end", Scope);
		} else {
			return null;
			//throw new Exception("Bad Syntax");
		}
	}
}