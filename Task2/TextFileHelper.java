import java.util.List;

public class TextFileHelper 
{
	public static List<String> GetLines(String FilePath) 
	{
		List<String> output = new List<String>();
		String tempLine;
		BufferedReader Br = new BufferedReader(new FileInputStream(FilePath));

		while ((tempLine = Br.readLine()) != null) {
			output.Add(eatIndents(tempLine));
		}
		return output;
	}

	private static String eatIndents(String inputLine) 
	{
		while (inputLine[0] == ' ') {
			inputLine.subString(1, inputLine.length());
		}
		return inputLine;
	}
}