import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		while(N!=1) {
			if(N%2==0) {
				N/= 2;
			}
			else {
				N = 3*N+1;
			}
			cnt++;
			if(N==1) {
				break;
			}
		}
		System.out.println(cnt+1);
	}

}
