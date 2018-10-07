import java.util;

private class Tokenizer 
{
	public static List<Token> TokenizeFile(List<String> InputLines) 
	{
		List<Token> output = new List<Token>();

		for (int i = 0; i < InputLines.size(); i++) {
			output.add(TokenizeLine(InputLines[i]));
		}
		return output;
	}

	private static Token TokenizeLine(String Line) 
	{
		return new Token(String MethodName, IntObj OperandA, int OperandB);
	}
}