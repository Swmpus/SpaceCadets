import java.util.ArrayList;
import java.util.List;

class Parser
{
	public static ArrayList<Node> GenerateTrees(ArrayList<ArrayList<Token>> lines) 
	{
		ArrayList<Node> output = new ArrayList<Node>();

		for (ArrayList<Token> line : lines) {
			output.add(GenerateTree(line));
		}
		return output;
	}

	private static Node GenerateTree(List<Token> line) 
	{
		if (line.get(0).Type.equals("Assignment")) {
			return new Node(GenerateTree(line.subList(1, 2)), line.get(0), GenerateTree(line.subList(2, line.size())));
		} else if (line.get(0).Type.equals("(")) {
			int pointer = getPointerToBracketBreak(line);
			Token top = line.get(pointer);
			line.remove(pointer);

			return new Node(GenerateTree(line.subList(1, pointer - 1)), top, GenerateTree(line.subList(pointer + 1, line.size() - 1)));
		} else if (line.get(0).Type.equals("Control") && line.size() == 1) {
			return new Node(null, line.get(0), null);
		} else if (line.get(0).Type.equals("Control")) {
			return new Node(GenerateTree(line.subList(2, line.size() - 1)), line.get(0), null);
		} else if (line.get(0).Type.equals("LogicFunction") && line.get(0).Type.equals("not")) {
			return new Node(GenerateTree(line.subList(2, line.size() - 1)), line.get(0), null);
		} else if (line.get(0).Type.equals("LogicFunction")) {
			return new Node(GenerateTree(line.subList(1, line.size())), line.get(0), null);
		} else if (line.get(0).Type.equals("Var") || line.get(0).Type.equals("BoolLiteral")) {
			return new Node(null, line.get(0), null);
		} else {
			return new Node(null, null, null);
		}
	}

	private static int getPointerToBracketBreak(List<Token> stream) 
	{
		int bracketcount = 0;
		int pointer = 0;

		do {
			if (stream.get(pointer).equals("(")) {
				bracketcount += 1;
			} else if (stream.get(pointer).equals(")")) {
				bracketcount -= 1;
			}
			pointer += 1;
		} while (bracketcount > 0);

		return pointer;
	}
}