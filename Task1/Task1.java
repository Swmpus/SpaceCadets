import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1
{
	public static void main(String[] args) // Entry point, expected args = {"ID"}
	{
		if (args.length > 1 || args.length < 1) { // Handle incorrect number of arguments passed
			System.out.println("First argument must be the ID to look up");
			return;
		}
		String HTMLString = HTTPHelper.GetHTML("https://www.ecs.soton.ac.uk/people/" + args[0]); // Retrieve the HTML
		String FoundName = GetNameFromHTML(HTMLString); // Find the name from the HTML

		if (HTMLString == null) { // Check for errors in retrieving HTML and finding name in HTML
			System.out.println("There was a problem with that URL");
		} else if (FoundName == null) {
			System.out.println("No name found");
		} else {
			System.out.println(FoundName); // No errors so print value
		}
	}

	private static String GetNameFromHTML(String InputHTML) 
	{
		if (InputHTML == null) {
			return null;
		}
		Pattern RegexPattern = Pattern.compile("property=\"name\">[A-Za-z\\s,.-]+</h1>"); // Generate regex pattern for matching
		Matcher MatchFinder = RegexPattern.matcher(InputHTML); // Find all matches of this regex string

		if (MatchFinder.find()) {
			return InputHTML.substring(MatchFinder.start(0) + 16, MatchFinder.end(0) - 5); // return the value of the first match without the tags if one was found
		}
		return null; // In case of an unexpected error occurring
	}
}