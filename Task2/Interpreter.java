import java.util.Stack;

private class Interpreter 
{
	private Stack<Token> state;
	private List<Token> tokenStream;

	public Interpreter(List<Token> InputTokens) 
	{
		state = new Stack<Token>();
		tokenStream = InputTokens;
	}

	public void Run() 
	{
		
	}
}