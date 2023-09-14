import java.io.*;

import java.util.*;



public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<T; i++) {
			int result = 0;
			int a = Integer.parseInt(st.nextToken());

			int mok3 = a/3;
			int mok7 = a/7;
			int mok21 = a/21;

			int sum = 0;
			for(int j=1; j<=mok3; j++) {
				sum+=j;
			}

			result+=3*sum;

			sum = 0;
			for(int j=1; j<=mok7; j++) {
				sum+=j;
			}

			result+=7*sum;

			sum=0;
			for(int j=1; j<=mok21; j++) {
				sum+=j;
			}
			result-=21*sum;

			sb.append(result+"\n");
		}

		System.out.println(sb);
		
	}
}	