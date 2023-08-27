
import java.io.*;
import java.util.*;


public class Main {

	public static List<Integer>[] edge;
	public static int[][] dp;
	public static boolean[] visit;
	public static int N;

	public static void DFS(int a) {
		visit[a] = true;
		dp[a][0] = 0;
		dp[a][1] = 1;

		for(int connect: edge[a]) {
			if(!visit[connect]) {
				DFS(connect);
				dp[a][0] += dp[connect][1];
				dp[a][1] += Math.min(dp[connect][0], dp[connect][1]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		edge = new ArrayList[N+1];
		dp = new int[N+1][2];

		StringTokenizer st;
		for(int i=1; i<=N; i++) {edge[i] = new ArrayList<>(); }


		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edge[a].add(b);
			edge[b].add(a);
		}

		DFS(1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

}
