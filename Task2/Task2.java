import java.util.ArrayList;
import java.io.IOException;

public class Task2
{
	public static void main(String[] args) throws IOException
	{
		Interpreter II = new Interpreter();

		ArrayList<Token> Tokens = Tokenizer.TokenizeFile(TextFileHelper.GetLines("C:/Users/Morgan/Desktop/Programming Projects/JavaStuff/SpaceCadets/Task2/TestOne.txt")); // This should be dynamic
		
		II.Run(Tokens);
	}
}