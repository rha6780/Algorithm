import java.util.*;
import java.io.*;

public class Main {
	
	public static long[] memo = new long[100];
	
	public static void dp () {
		for(int i=0; i<36; i++) {
			if(i==0) {memo[0]=1;}
			else if(i==1) {memo[1]=1;}
			else {
				long sum=0;
				for(int j=0; j<i; j++) {
					sum+= memo[j]*memo[i-j-1];
				}
				memo[i]=sum;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int num = Integer.parseInt(br.readLine());
		
		dp();
		
		System.out.println(memo[num]);
		
	}

}
