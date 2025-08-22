import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		BigInteger[] num = new BigInteger[1000001];
		num[0] = BigInteger.ZERO;
		num[1] = BigInteger.ONE;
		num[2] = BigInteger.ONE;
		if (N < 3) {System.out.println(num[N]);}
 		else {
			for(int i=3; i<=N; i++) {
				num[i] = num[i-1].add(num[i-2]);
			}
			System.out.println(num[N]);
		}
	}

}
