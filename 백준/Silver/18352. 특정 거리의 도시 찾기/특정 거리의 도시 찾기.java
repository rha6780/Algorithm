import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] road;
	static boolean[] visit;
	static int[] cost;
	
	static void Dijkstra(int s, int N) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(s);
		visit[s]=true;
		cost[s]=0;
		while(!que.isEmpty()) {
			int t = que.poll();
			visit[t]=true;
			for(int i=0; i<road[t].size(); i++) {
				int p = road[t].get(i);
				if(!visit[p]) {
					if(cost[p]>cost[t]+1) {
						cost[p]=cost[t]+1;
						que.add(p);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		cost = new int[N+1];
		visit = new boolean[N+1];
		road = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			cost[i]=Integer.MAX_VALUE;
			road[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			road[a].add(b);
		}
		
		Dijkstra(X, N);
		int count=0;
		for(int i=1; i<=N; i++) {
			if(cost[i]==K){
				System.out.println(i);
				count++;
			}
		}
		if(count==0) {
			System.out.print(-1);
		}
	}

}
