import java.util.Stack;
import java.util.List;

private class Interpreter 
{
	private List<String> operationsList;
	private List<Token> tokenStream;
	private Map<String, IntObj> variableDict;

	public Interpreter() 
	{
		tokenStream = new List<Token>();
		variableDict = new Map<String, IntObj>();
		operationsList = new List<String>();

		operationsList.add("clear");
		operationsList.add("incr");
		operationsList.add("decr");
	}

	public void Run(List<Token> InputTokens) 
	{
		tokenStream = InputTokens;
		int streamPointer = 0;

		while (streamPointer < tokenStream.size()) {

			if (operationsList.contains(tokenStream[streamPointer].opcode)) {
				ExecuteToken(tokenStream[streamPointer]);
				streamPointer += 1;
			} else if (tokenStream[streamPointer].opcode == "end") {

				while (tokenStream[streamPointer].opcode != "not") {
					streamPointer -= 1;
				}
			}  else if (tokenStream[streamPointer].opcode == "not") {

				if (Operations.not(variableDict.get(Token.OperandA), Token.OperandB)) {
					streamPointer += 1;
				} else {

					while (tokenStream[streamPointer].opcode != "end") {
						streamPointer += 1;
					}
					streamPointer += 1;
				}
			}
		}
	}

	private void ExecuteToken(Token input) // Need to implement function pointers for this task
	{
		if (input.opcode == "clear" && variableDict.containsKey(Token.OperandA)) {
			Operations.clear(variableDict.get(Token.OperandA));
		} else if (input.opcode == "clear" && !variableDict.containsKey(Token.OperandA)) {
			variableDict.put(Token.OperandA, new IntObj(0));
		} else if (input.opcode == "incr") {
			Operations.incr(variableDict.get(Token.OperandA), Token.OperandB);
		} else if (input.opcode == "decr") {
			Operations.decr(variableDict.get(Token.OperandA), Token.OperandB);
		}
	}
}