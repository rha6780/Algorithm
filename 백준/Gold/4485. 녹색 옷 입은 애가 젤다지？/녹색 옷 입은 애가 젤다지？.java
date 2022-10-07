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
public class Main {
	static int[] rc= {0,0,-1,1};
	static int[] cc= {-1,1,0,0};
	static int N=1;
	static Vector<Vector<Edge>> edge;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=1;
		while(true) {
			N=sc.nextInt();
			if(N==0) {break;}
			edge=new Vector<Vector<Edge>>();
			int[][] field=new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j++) {
					field[i][j]=sc.nextInt();
					Vector<Edge> e=new Vector<Edge>();
					edge.add(e);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int h=0; h<4; h++) {
						if(i+rc[h]>=0&&i+rc[h]<N&&j+cc[h]>=0&&j+cc[h]<N) {
							Edge e=new Edge((i+rc[h])*N+(j+cc[h]),field[i+rc[h]][j+cc[h]]);
							edge.get((N*i)+j).add(e);
						}
					}
				}
			}
			
			Vector<Integer> dist=dijkstra(0, field[0][0]);
			
			System.out.println("Problem "+count+": "+(dist.elementAt((N*N)-1)+field[0][0]));
			count++;
		}

	}
	public static Vector<Integer> dijkstra(int cur, int c){
		PriorityQueue<Edge> que=new PriorityQueue<Edge>();
		Vector<Integer> dist=new Vector<Integer>();
		for(int i=0; i<=N*N; i++) {
			if(i==cur) {dist.add(0);}
			else {dist.add(-1);}
		}
		que.add(new Edge(cur, 0));
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
