import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;

public class Interpreter 
{
	private ArrayList<String> operationsList;
	private ArrayList<Token> tokenStream;
	private HashMap<String, Integer> variableDict;

	public Interpreter() 
	{
		tokenStream = new ArrayList<Token>();
		variableDict = new HashMap<String, Integer>();
		operationsList = new ArrayList<String>();

		operationsList.add("clear");
		operationsList.add("incr");
		operationsList.add("decr");
	}

	public void Run(ArrayList<Token> InputTokens) 
	{
		tokenStream = InputTokens;
		int streamPointer = 0;

		while (streamPointer < tokenStream.size()) {

			if (operationsList.contains(tokenStream.get(streamPointer).Opcode)) {
				ExecuteToken(tokenStream.get(streamPointer));
				streamPointer += 1;
			} else if (tokenStream.get(streamPointer).Opcode == "end") {

				while (tokenStream.get(streamPointer).Opcode != "not") {
					streamPointer -= 1;
				}
			}  else if (tokenStream.get(streamPointer).Opcode == "not") {

				if (Operations.not(variableDict.get(tokenStream.get(streamPointer).OperandA), tokenStream.get(streamPointer).OperandB)) {
					streamPointer += 1;
				} else {

					while (tokenStream.get(streamPointer).Opcode != "end") {
						streamPointer += 1;
					}
					streamPointer += 1;
				}
			}
		}
	}

	private void ExecuteToken(Token input) // Need to implement function pointers for this task
	{
		if (input.Opcode == "clear") {
			variableDict.put(input.OperandA, 0);
		} else if (input.Opcode == "incr") {
			variableDict.put(input.OperandA, Operations.incr(variableDict.get(input.OperandA), input.OperandB));
		} else if (input.Opcode == "decr") {
			variableDict.put(input.OperandA, Operations.decr(variableDict.get(input.OperandA), input.OperandB));
		}
	}
}