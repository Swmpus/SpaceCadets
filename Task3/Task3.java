import java.io.IOException;

class Task3 
{
	public static void main(String[] args) throws IOException
	{
		Parser.GenerateTrees(Lexer.TokenizeFile(TextFileHelper.GetLines("C:/Users/Morgan/Desktop/Programming Projects/JavaStuff/SpaceCadets/Task3/Sample.PAWEL")));
	}
}