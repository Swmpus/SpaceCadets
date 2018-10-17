import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class BBCompile
{
	public static void main(String[] args) throws SecurityException
	{
		if (args.length >  1 || args.length < 1) {
			System.out.println("First and only argument should be the name of the file to compile");
			System.exit(-1);
		}

		Compiler II = new Compiler(true);
		ArrayList<Token> Tokens = new ArrayList<Token>();

		try {
			File currentDirectory = new File(new File(".").getAbsolutePath());
 
			Tokens = Tokenizer.TokenizeFile(TextFileHelper.GetLines(currentDirectory.getCanonicalPath() + "/" + args[0]));

		} catch(IOException e) {
			System.out.println("Sorry there was a problem with that file");
			System.exit(-1);
		}		
		II.Run(Tokens);
	}
}
