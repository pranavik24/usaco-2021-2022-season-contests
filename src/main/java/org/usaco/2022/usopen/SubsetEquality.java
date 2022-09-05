import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubsetEquality {

	public static void main(String[] args) throws IOException {

		//long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String string1 = br.readLine(); 
		String string2 = br.readLine(); 
		
		int numQueries = Integer.parseInt(br.readLine());
		
		StringBuilder st1, st2; 
		StringBuilder answer = new StringBuilder();
		char[] st1Arr = string1.toCharArray();
		char[] st2Arr = string2.toCharArray();
		for(int q = 0; q < numQueries; q++) {
			 String query = br.readLine();  
			 //java.util.regex.Pattern q = Pattern.compile("[^" + query+ "]"); 
			// System.out.println("q = " + query);//
//			 st1 = string1.replaceAll("[^" + query + "]", ""); 
//			 st2 = string2.replaceAll("[^" + query + "]" , ""); 
				char[] queryArr = query.toCharArray();

			 st1 = getString(st1Arr, queryArr);
			 st2 = getString(st2Arr, queryArr);
			 //System.out.println(st1.equals(st2));
			// System.out.println("Str1 = " + st1 + "\tStr2 = " + st2);
			 if ( st1.length() != st2.length()) {
				 answer.append('N'); 
			 } else {
				 boolean same = true;
				 for ( int i =0;i < st1.length();++i) {
					 if ( st1.charAt(i) != st2.charAt(i)) {
						 answer.append('N');
						 same = false;
						 break;
					 }
				 }
				 if ( same) {
					 answer.append('Y'); 
				 }
			 }
//			 if(st1.equals(st2)){
//				 answer.append('Y'); 
//			 }
//			 else {
//				 answer.append('N'); 
//			 }
		}
		//long end = System.currentTimeMillis();
	    //System.out.println("Time: "+ ( end - start));
		System.out.println(answer.toString());
		

	}

	public static StringBuilder getString(char[] strArr, char[]  queryArr) {
		StringBuilder result = new StringBuilder();
		for(char curChar : strArr) {
			for (char queryChar : queryArr) {
				if ( curChar == queryChar) {
					result.append(curChar);
					break;
				}
			}
		}
		return result;
	}

}
