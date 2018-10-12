public class Token 
{
	public String Opcode;
	public String OperandA;
	public int OperandB;
	public int Scope;

	public Token(String InCode, int InScope) 
	{
		Opcode = InCode;
		OperandA = "";
		OperandB = 0;
		Scope = InScope;
	}

	public Token(String InCode, String Inop) 
	{
		Opcode = InCode;
		OperandA = Inop;
		OperandB = 0;
		Scope = -1;
	}

	public Token(String InCode, String InopA, int InopB) 
	{
		Opcode = InCode;
		OperandA = InopA;
		OperandB = InopB;
		Scope = -1;
	}

	public Token(String InCode, String InopA, int InopB, int InScope) 
	{
		Opcode = InCode;
		OperandA = InopA;
		OperandB = InopB;
		Scope = InScope;
	}
}