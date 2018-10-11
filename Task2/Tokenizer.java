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
		String incrReg = "incr\s[a-zA-Z]+[a-zA-Z0-9]*\s?[0-9]*";
		String decrReg = "incr\s[a-zA-Z]+[a-zA-Z0-9]*\s?[0-9]*";
		String clearReg = "clear\s[a-zA-Z]+[a-zA-Z0-9]*"
		String notReg = "[a-zA-Z]+[a-zA-Z0-9]*\s not \s?[0-9]*"
		String whiledoReg = "while\s[a-zA-Z0-9\s]*\sdo"

		return new Token(String MethodName, IntObj OperandA, int OperandB);
	}
}