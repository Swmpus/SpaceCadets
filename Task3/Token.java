class Token
{
	public String Type;
	public String Value;
	public int Scope;

	public Token(String type, String value, int scope) 
	{
		this.Type = type;
		this.Value = value;
		this.Scope = scope;
	}
}