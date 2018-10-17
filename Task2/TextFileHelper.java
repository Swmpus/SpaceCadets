import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TextFileHelper 
{
	public static ArrayList<String> GetLines(String FilePath) throws IOException, FileNotFoundException
	{
		ArrayList<String> output = new ArrayList<String>();
		String tempLine;
		BufferedReader Br = new BufferedReader(new FileReader(FilePath));

		while ((tempLine = Br.readLine()) != null) {
			if (tempLine.length() != 0) {
				output.add(eatIndents(tempLine));		
			}
		}
		return output;
	}

	private static String eatIndents(String inputLine) 
	{
		while (inputLine.charAt(0) == ' ') {
			inputLine = inputLine.substring(1, inputLine.length());
		}
		return inputLine;
	}
}