import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, ArrayList<Integer>> arr = new HashMap<Integer, ArrayList<Integer>>();
		
		int[][] field = new int[M+1][N+1];
		int[][] block = new int[M+1][N+1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				field[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(field[i][j]>0) {continue;}
				
				block[i][j]=Math.min(Math.min(block[i-1][j], block[i][j-1]), block[i-1][j-1])+1;
				
				result = Math.max(result, block[i][j]);
			}
		}
		System.out.println(result);
		
	}

}
