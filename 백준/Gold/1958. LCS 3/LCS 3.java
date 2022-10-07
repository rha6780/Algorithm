import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int[][][] LCS = new int[a.length()+1][b.length()+1][c.length()+1];
		
		for(int i=1; i<=a.length(); i++) {
			for(int j=1; j<=b.length(); j++) {
				for(int h=1; h<=c.length(); h++) {
					if(a.charAt(i-1) == b.charAt(j-1)&&a.charAt(i-1)==c.charAt(h-1)) {
						LCS[i][j][h] = LCS[i-1][j-1][h-1]+1;
					}
					else {
						LCS[i][j][h] = Math.max(LCS[i-1][j][h], Math.max(LCS[i][j-1][h], LCS[i][j][h-1]));
					}
				}
			}
		}
		
		System.out.println(LCS[a.length()][b.length()][c.length()]);
		
	}

}
 