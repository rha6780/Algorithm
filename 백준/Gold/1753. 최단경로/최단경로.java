import java.util.*;
import java.util.Vector;
class Edge implements Comparable<Edge>{
	int dst, weight;
	public Edge(int dst, int weight) {
		this.dst=dst; this.weight=weight;
	}
	@Override
	public int compareTo(Edge arg) {
		return this.weight-arg.weight;
	}
}
public class Main {
	static Vector<Vector<Edge>> edge=new Vector<Vector<Edge>>();
	static int n, m, s;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt(); m=sc.nextInt(); s=sc.nextInt();
		edge=new Vector<Vector<Edge>>();
		for(int i=0; i<n+1; i++) {
			Vector<Edge> e=new Vector<Edge>();
			edge.add(e);
		}
		for(int i=0; i<m; i++) {
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			Edge e=new Edge(v,w);
			edge.elementAt(u).add(e);
		}
		Vector<Integer> dist=dijkstra(s);
		for(int i=1; i<=n; i++) {
			if(dist.elementAt(i)!=-1)System.out.println(dist.elementAt(i));
			else {System.out.println("INF");}
		}
	}
	public static Vector<Integer> dijkstra(int cur){
		PriorityQueue<Edge> que=new PriorityQueue<>();
		Vector<Integer> dist=new Vector<Integer>();
		for(int i=0; i<=n; i++) {
			if(cur==i)dist.add(0); 
			else dist.add(-1);
		}
		Edge e=new Edge(cur, 0);
		que.add(e);
		while(!que.isEmpty()) {
			Edge here=que.remove();
			for(int i=0; i<edge.elementAt(here.dst).size(); i++) {
				Edge a=edge.elementAt(here.dst).elementAt(i);
				int there=a.dst, nextdist=dist.elementAt(here.dst)+a.weight;
				if(dist.elementAt(there)==-1|| dist.elementAt(there)>nextdist){
					dist.setElementAt(nextdist, there);
					Edge ne=new Edge(there, nextdist);
					que.add(ne);
				}
			}
		}
		return dist;
	}
}
