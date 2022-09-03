import java.util.*;
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
public class Main{
	public static int[] rc= {0,0,-1,1};
	public static int[] cc= {-1,1,0,0};
	static int m, n;
	static Vector<Vector<Edge>> edge=new Vector<Vector<Edge>>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt(); n=sc.nextInt();
		char[][] room=new char[n][m];
		
		for(int i=0; i<n; i++) {
			String s=sc.next();
			room[i]=s.toCharArray();
			for(int j=0; j<m; j++) {
				Vector<Edge> e=new Vector<Edge>();
				edge.add(e);
			}
		}
		int count=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int h=0; h<4; h++) {
					int cost=0;
					if(i+rc[h]>=0&&i+rc[h]<n&&j+cc[h]>=0&&j+cc[h]<m) {
						if(room[i+rc[h]][j+cc[h]]=='1') {cost=1;}
						Edge e=new Edge(((i+rc[h])*m+(j+cc[h])),cost);
						edge.get((i*m)+j).add(e);
						//System.out.println(i+" "+j+" "+cost);
					}
				}
				count++;
			}
		}
		Vector<Integer> dist=dijkstra(0);
		System.out.println(dist.elementAt((n*m)-1));

	}
	public static Vector<Integer> dijkstra(int cur) {
		PriorityQueue<Edge> que=new PriorityQueue<Edge>();
		Vector<Integer> dist=new Vector<Integer>();
		for(int i=0; i<=n*m; i++) {
			if(cur==i) {dist.add(0);}
			else {dist.add(-1);}
		}
		Edge e=new Edge(cur, 0);
		que.add(e);
		while(!que.isEmpty()) {
			Edge here=que.remove();
			for(int i=0; i<edge.elementAt(here.dst).size(); i++) {
				Edge a=edge.elementAt(here.dst).elementAt(i);
				int there=a.dst; int nextdist=dist.elementAt(here.dst)+a.weight;
				if(dist.elementAt(there)==-1||dist.elementAt(there)>nextdist) {
					dist.setElementAt(nextdist, there);
					Edge ne=new Edge(there, nextdist);
					que.add(ne);
				}
			}
		}
		return dist;
	}

}
