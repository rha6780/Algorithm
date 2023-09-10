
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] strs = new String[5];
		
		
		int max_len=0;
		for(int i=0; i<5; i++) {
			strs[i] = br.readLine();
			max_len = Math.max(strs[i].length(), max_len);
		}
		
		String result = "";
		
		
		for(int j=0; j<max_len; j++) {
			for(int i=0; i<5; i++) {
				if(strs[i].length()>j) {
					result += strs[i].charAt(j);	
				}
			}
		}
		
		System.out.println(result);
	}

}

