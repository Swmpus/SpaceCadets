import java.util.Arrays;
import java.net.*;
import java.io.*;

public class HTTPHelper // Helper class to provide a function to retrieve HTML from a URL
{
	public static String GetHTML(String InputURL) // Returns entire HTML file from a requested URL
	{
		BufferedReader HTMLReader;
		String HTMLString = "";

		try {
			String outputline = "";
			URLConnection conn =  (new URL(InputURL)).openConnection(); // Initialise the connection and reader objects required to get the stream
			HTMLReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			while ((outputline = HTMLReader.readLine()) != null) { // Check if the next line exists
				HTMLString += outputline; // Next line exists so add it to the output
			}
			return HTMLString;
		} catch (IOException e) { // Catche the case where the connection can't be made or there is an unexpected error trying to read the stream etc.
			return null;
		}
	}
}