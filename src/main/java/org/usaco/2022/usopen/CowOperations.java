import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CowOperations {
	static Pattern patt0 = Pattern.compile("OO|WW|CC");
	static Pattern patt1 = Pattern.compile("OC|CO");
	static Pattern patt2 = Pattern.compile("WW");
	static Pattern patt3 = Pattern.compile("OW|WO");
	static Pattern patt4 = Pattern.compile("CC");
	static Pattern patt5 = Pattern.compile("WC|CW");
	static Pattern patt6 = Pattern.compile("OO");

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = reader.readLine();
		int numSubStrings = Integer.parseInt(reader.readLine());
		for (int i = 0; i < numSubStrings; i++) {
			String[] indexes = reader.readLine().split(" ");
			int startIndex = Integer.parseInt(indexes[0]);
			int endIndex = Integer.parseInt(indexes[1]);
			System.out.print(canReduce(inputStr.substring(startIndex - 1, endIndex)));
		}
	}

	public static String canReduce(String str) {
		String result = patt2.matcher(str).replaceAll("");
		result = patt4.matcher(result).replaceAll("");
		result = patt6.matcher(result).replaceAll("");

		while (result.length() > 1) {
			result = patt1.matcher(result).replaceAll("W");
			result = patt2.matcher(result).replaceAll("");
			result = patt3.matcher(result).replaceAll("C");
			result = patt4.matcher(result).replaceAll("");
			result = patt5.matcher(result).replaceAll("O");
			result = patt6.matcher(result).replaceAll("");
		}
		return "C".equals(result) ? "Y" : "N";

	}
}
