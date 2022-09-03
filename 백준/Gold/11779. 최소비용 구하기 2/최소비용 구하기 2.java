import java.util.*;
import java.io.*;

class Bus implements Comparable<Bus>{
	int e, cost;
	public Bus(int e, int cost) {
		this.e=e; this.cost=cost;
	}
	@Override
	public int compareTo(Bus o) {
		return this.cost-o.cost;
		
	}
	
}

public class Main {
	 
	static boolean[]visit=new boolean[100];
	static int[] cost;
	static int N, M;
	static int[] Rroute;
	static ArrayList<Bus>[] way; 
	
	static void Dijkstra(int s, int e) {
		PriorityQueue<Bus> que = new PriorityQueue<Bus>();
		
		cost[s]=0;
		Rroute[s]=0;
		que.add(new Bus(s,0));
		while(!que.isEmpty()) {
			Bus t = que.poll();
			if(!visit[t.e]) {visit[t.e]=true;}
			else continue;
			for(int i=0; i<way[t.e].size(); i++) {
				Bus bb = way[t.e].get(i);
				
				if(cost[bb.e]>cost[t.e]+bb.cost) {
					cost[bb.e]=cost[t.e]+bb.cost;
					que.offer(new Bus(bb.e,cost[bb.e]));
					Rroute[bb.e]=t.e;
				}
				
			}
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visit = new boolean[N+1];
		cost = new int[N+1];
		Rroute= new int[N+1];
		way = new ArrayList[N+1];
		
		//Arrays.fill(cost, Integer.MAX_VALUE);
		for(int i=0; i<=N; i++) {
			cost[i] = 1000000001;
			way[i] = new ArrayList<Bus>();
		}
		
		for(int i=0; i<M; i++) {
			//st = new StringTokenizer(br.readLine());
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			way[a].add(new Bus(b,c));
		}
		//st = new StringTokenizer(br.readLine());
		int s = sc.nextInt();
		int e = sc.nextInt();
		Dijkstra(s, e);
		System.out.println(cost[e]);
		int cnt=0;
		String a="";
		
		while(e!=0) {
			a=e+" "+a;
			int ee=Rroute[e];
			e=ee;
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(a);

	}

}
