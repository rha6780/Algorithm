import java.io.*;
import java.util.*;

public class Main {

	static List<Node>[] arr;
	static int[] dp;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		dp = new int[n+1];
		check = new boolean[n+1];
		
		for(int i=1; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[from].add(new Node(to,cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start= Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		
		
		dijkstra(start);
		System.out.println(dp[destination]);

		
	}
	
	static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		q.add(new Node(start,0));
		dp[start] =0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int to = node.to;
			 
			if(check[to]) continue;
			
			check[node.to] = true;
			for(Node next : arr[to]) {
				if(dp[next.to] >= dp[to] + next.cost) {
					dp[next.to] = dp[to] + next.cost;
					q.add(new Node(next.to, dp[next.to]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int to;
	int cost;
	
	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}