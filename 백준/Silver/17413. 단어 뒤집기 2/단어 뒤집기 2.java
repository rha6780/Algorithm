import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		char[] arr = S.toCharArray();

		for (int i=0; i< arr.length; ) {
			char current = arr[i];
			
			if (current == '<') {
				if (sb.length() > 0) {
					String reversedStr = sb.reverse().toString();
					result.append(reversedStr);
					sb.setLength(0);
				}
				while (current != '>') {
					current = arr[i];
					sb.append(current);
					i++;
				}
				result.append(sb.toString());
				sb.setLength(0);
			} else {
				if (current == ' ') {
					if (sb.length() > 0) {
						String reversedStr = sb.reverse().toString();
						result.append(reversedStr);
					}
					result.append(" ");
					sb.setLength(0);
				} else {
					sb.append(current);
				}
				i++;
			}
		}

		if (sb.length() > 0) {
			if (sb.charAt(0) != '<') {
				result.append(sb.reverse().toString()); 
			} else {
				result.append(sb.toString());
			}
		}

		System.out.println(result.toString());
	}

}

