import java.util.*;
import java.io.*;

public class Main {
	
	static long[][] memo;
	
	public static long multif(long a, long n) {
		long m=1;
		for(int i=1; i<=n; i++) {
			m*=a;
		}
		return m; 
	}
	
	public static long updw(int k, int left) {
		if(k==left) {
			return 1;
		}
		if(left==0) {
			return 0;
		}
		if(k==0) {
			return multif(2, left);
		}
		if(memo[k][left] != -1) {
			return memo[k][left];
		}
		long t1 = updw(k+1, left-1); //up
		long t2 = updw(k-1, left-1); //down
		memo[k][left] = t1+t2;
		return memo[k][left];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		memo = new long[K+N+1][N+1];
		for(int j=0; j<K+N+1; j++) {
			for(int i=0; i<N+1; i++) {
				memo[j][i]=(-1);
			}
		}
		long a =multif(2,N);
		System.out.println(a-updw(K, N));

	}

}
