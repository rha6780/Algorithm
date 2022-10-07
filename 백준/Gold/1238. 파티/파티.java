import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {

	int index,  cost;
	public Node(int i, int cost) {
		this.index=i;
		
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost-o.cost;
	}
	
}

public class Main {

	static int[][] road = new int[100][100];
	static int[] cost;
	static boolean[] visit;
	static int N, M;
	
	static void Dijkstra(int s) {
		visit[s]=true;
		PriorityQueue<Node> que = new PriorityQueue<Node>();
		que.add(new Node(s,0));
		cost[s]=0;
		while(!que.isEmpty()) {
			Node n = que.poll();
			int t=n.index;
			visit[t]=true;
			for(int i=1; i<=N; i++) {
				if(!visit[i]&&road[t][i]!=-1) {
					if(cost[i]>cost[t]+road[t][i]) {
						cost[i]=cost[t]+road[t][i];
						que.add(new Node(i,cost[i]));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		road = new int[N+1][N+1];
		cost = new int[N+1];
		visit= new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			cost[i]=Integer.MAX_VALUE;
			for(int j=1; j<=N; j++) {
				road[i][j]=-1;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			road[a][b]=c;
		}
		
		int max=0;
		int[] back = new int[N+1];
		int[] go = new int[N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(cost, Integer.MAX_VALUE);
			visit= new boolean[N+1];
			Dijkstra(i);
			go[i]=cost[X];
			if(i==X) {
				for(int j=1; j<=N; j++) {
					back[j]=cost[j];
				}
			}
		}
		for(int i=1; i<=N; i++) {
			max=Math.max(max, (back[i]+go[i]));
		}
		System.out.println(max);
	}

}
