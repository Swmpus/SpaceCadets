import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class Task2
{
	public static void main(String[] args) throws IOException // nested whiles do not currently work
	{
		Interpreter II = new Interpreter();

		File currentDirectory = new File(new File(".").getAbsolutePath());

		ArrayList<Token> Tokens = Tokenizer.TokenizeFile(TextFileHelper.GetLines(currentDirectory.getCanonicalPath() + "/TestThree.txt")); // This should be dynamic
		
		II.Run(Tokens);
	}
}