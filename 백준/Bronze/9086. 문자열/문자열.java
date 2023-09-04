import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();

			sb.append(str.charAt(0));
			sb.append(str.charAt(str.length()-1));
			sb.append("\n");
		}

		System.out.println(sb);
	}

}