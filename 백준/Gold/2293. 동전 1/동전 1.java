import java.io.*;
import java.util.*;

public class Main {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N+1];
		int[] result = new int[K+1];
		
		result[0] = 1;

		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			coin[i] = n;
		}

		for (int i=0; i<N; i++) {
			for (int j=coin[i]; j<=K; j++) {
				result[j] = result[j] + result[j - coin[i]];
			}
		}

		System.out.println(result[K]);
	}

}
