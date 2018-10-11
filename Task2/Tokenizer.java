import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Tokenizer 
{
	public static ArrayList<Token> TokenizeFile(ArrayList<String> InputLines) 
	{
		ArrayList<Token> output = new ArrayList<Token>();

		for (int i = 0; i < InputLines.size(); i++) {
			output.add(TokenizeLine(InputLines.get(i)));
		}
		return output;
	}

	private static Token TokenizeLine(String Line) 
	{
		Pattern incrReg = Pattern.compile("incr\\s[a-zA-Z]+[a-zA-Z0-9]*\\s?[0-9]*;");
		Pattern decrReg = Pattern.compile("incr\\s[a-zA-Z]+[a-zA-Z0-9]*\\s?[0-9]*;");
		Pattern clearReg = Pattern.compile("clear\\s[a-zA-Z]+[a-zA-Z0-9]*;");
		Pattern notReg = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*\\s not \\s?[0-9]*");
		Pattern whiledoReg = Pattern.compile("while\\s[a-zA-Z0-9\\s]*\\sdo;");

		Matcher incrMatch = incrReg.matcher(Line);
		Matcher decrMatch = decrReg.matcher(Line);
		Matcher clearMatch = clearReg.matcher(Line);
		Matcher notMatch = notReg.matcher(Line);
		Matcher whiledoMatch = whiledoReg.matcher(Line);

		if (incrMatch.matches()) {
			Line = Line.substring(6, Line.length() - 1);
			String[] parts = Line.split(" ");

			if (parts.length == 1) {
				return new Token("incr", parts[0]);
			} else {
				return new Token("incr", parts[0], Integer.parseInt(parts[1]));
			}
		} else if (decrMatch.matches()) {
			Line = Line.substring(6, Line.length() - 1);
			String[] parts = Line.split(" ");

			if (parts.length == 1) {
				return new Token("decr", parts[0]);
			} else {
				return new Token("decr", parts[0], Integer.parseInt(parts[1]));
			}
		} else if (clearMatch.matches()) {
			Line = Line.substring(7, Line.length() - 1);

			return new Token("clear", Line);
		} else if (whiledoMatch.matches()) {
			Line = Line.substring(7, Line.length() - 4);
			String[] parts = Line.split(" not ");

			return new Token("not", parts[0], Integer.parseInt(parts[1]));
		} else if (Line == "end;") {
			return new Token("end");
		} else {
			return null;
			//throw new Exception("Bad Syntax");
		}
	}
}