public class Token 
{
	public String Opcode;
	public String OperandA;
	public int OperandB;

	public Token(String InCode) 
	{
		Opcode = InCode;
		OperandA = "";
		OperandB = 0;
	}

	public Token(String InCode, String Inop) 
	{
		Opcode = InCode;
		OperandA = Inop;
		OperandB = 0;
	}

	public Token(String InCode, String InopA, int InopB) 
	{
		Opcode = InCode;
		OperandA = InopA;
		OperandB = InopB;
	}
}