private class Token 
{
	public String Opcode;
	public IntObj OperandA;
	public Int OperandB;

	public Token(String InCode, IntObj Inop) 
	{
		opcode = InCode;
		operandA = Inop;
		operandB = 0;
	}

	public Token(String InCode, IntObj InopA, int InopB) 
	{
		opcode = InCode;
		operandA = InopA;
		operandA = InopB;
	}
}