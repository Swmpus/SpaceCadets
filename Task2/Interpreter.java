import java.util.Stack;

private class Interpreter 
{
	private List<String> operationsList;
	private Stack<Token> temporaryState;
	private List<Token> tokenStream;

	public Interpreter(List<Token> InputTokens) 
	{
		state = new Stack<Token>();
		operationsList = new List<String>();
		tokenStream = InputTokens;

		operationsList.add("clear");
		operationsList.add("incr");
		operationsList.add("decr");
		operationsList.add("end");
	}

	public void Run() 
	{
		int streamPointer = 0;

		while (streamPointer < tokenStream.size()) {
			if (operationsList.contains(tokenStream[streamPointer].opcode)) {
				ExecuteToken(tokenStream[streamPointer]);
				streamPointer += 1;
			} else if (tokenStream[streamPointer].opcode == "whiledo") {
				temporaryState.push();
				streamPointer += 1;
			} else if (tokenStream[streamPointer].opcode == "end") {
				while (tokenStream[streamPointer].opcode != "whiledo") {
					streamPointer -= 1; // need to make while loop completion work
				}
			}
		}
	}

	private void ExecuteToken(Token input)
	{
		if (input.opcode == "clear") {
			Operations.clear(Token.OperandA);
		} else if (input.opcode == "incr") {
			Operations.incr(Token.OperandA);
		} else if (input.opcode == "decr") {
			Operations.decr(Token.OperandA, Token.OperandB);
		} else if (input.opcode == "not") {
			Operations.not(Token.OperandA, Token.OperandB);
		}
	}
}