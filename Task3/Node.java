class Node 
{
	public Token ThisNode;
	public Node LeftChild;
	public Node RightChild;

	public Node(Node LeftChild, Token ThisNode, Node RightChild) 
	{
		this.ThisNode = ThisNode;
		this.LeftChild = LeftChild;
		this.RightChild = RightChild;
	}
}