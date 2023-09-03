import java.io.*;
import java.util.*;

public class Main {

	public static long phi (long n) {
		long num = n;
		for(int i=2; i<=Math.sqrt(n); i++) {
				if(n%i == 0){
					num = num/i*(i-1);
				}
				while(n%i == 0) {
					n/=i;
				}
		}
	
		if(n!=1) {
				num = num/n*(n-1);
		}
		return num;
	 }


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		System.out.println(phi(N));
	}
}
