import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] number = new int[N+1];
		for(int i=1; i<=N; i++) {
			number[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int j=0; j<=(b-a)/2; j++) {
				int temp = number[a+j];
				number[a+j] = number[b-j];
				number[b-j] = temp;
				// System.out.println(j+"에서"+(a+j) +" "+number[a+j] +" "+ (b-j) +" " + number[b-j]);
			}

			// System.out.println(i +"번째");
			// for(int h=1; h<=N; h++) {
			// 	System.out.println(number[h]);
			// }
		}

		for(int i=1; i<=N; i++) {
			System.out.println(number[i]);
		}

	}

}
