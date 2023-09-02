import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] count = new int[26];

		for(int i=0; i<str.length(); i++) {
			char a = str.charAt(i);
			count[(a-'a')]++;
		}

		for(int i=0; i<26; i++) {
			System.out.print(count[i]+" ");
		}

	}

}