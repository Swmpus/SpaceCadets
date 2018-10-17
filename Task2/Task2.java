import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class BBCompile
{
	public static void main(String[] args) throws IOException
	{
		if (args.length >  1) {
			System.out.println("First and only argument should be the name of the file to compile");
		}

		Interpreter II = new Interpreter();
		
		File currentDirectory = new File(new File(".").getAbsolutePath());

		ArrayList<Token> Tokens = Tokenizer.TokenizeFile(TextFileHelper.GetLines(currentDirectory.getCanonicalPath() + args[0]));
		
		II.Run(Tokens);
	}
}