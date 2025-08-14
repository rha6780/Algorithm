import java.util.*;

class Edge implements Comparable<Edge>{
	int dist, weight;
	public Edge(int dist, int weight){
		this.dist=dist; this.weight=weight;
	}
	@Override
	public int compareTo(Edge arg){
		return this.weight-arg.weight;
	}
}
public class Main {

	public static int N=0, K=0;
	public static Vector<Vector<Edge>> edge;
	public static Vector<int[]> Dijkstra(int cur){
		PriorityQueue<Edge> que=new PriorityQueue<Edge>();
		Vector<int[]> dist=new Vector<int[]>();
        
		
		for(int i=0; i<200010; i++){
			dist.add(new int[]{-1, 0});
		}
        dist.get(cur)[0] = 0;
        dist.get(cur)[1] = 1;

        que.add(new Edge(cur,0));

		while(!que.isEmpty()){
			Edge here=que.remove();
            int dis = dist.get(here.dist)[0];
            int count = dist.get(here.dist)[1];

			for(int i=0; i<edge.elementAt(here.dist).size(); i++){
				Edge a=edge.elementAt(here.dist).elementAt(i);
				int there=a.dist; 
                int nextdist= dis +a.weight;
				if(dist.elementAt(there)[0]==-1 || dist.elementAt(there)[0] > nextdist){
					dist.get(there)[0] = nextdist;
                    dist.get(there)[1] = count;
                    que.add(new Edge(there, nextdist));
				} else if (dist.get(there)[0] == nextdist) {
                    dist.get(there)[1] = dist.get(there)[1] + count; 
                }
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		edge=new Vector<Vector<Edge>>();
		for(int i=0; i<200010; i++){
			Vector<Edge> e=new Vector<Edge>();
			edge.add(e);
		}
		for(int i=0; i<200010; i++){
			if(i>0){Edge e=new Edge(i-1,1); edge.elementAt(i).add(e); }
			if(i<=200000){Edge e=new Edge(i+1,1); edge.elementAt(i).add(e);}
			if(i<=100000){Edge e=new Edge(i*2,1); edge.elementAt(i).add(e);}
		}
		Vector<int[]> dist=Dijkstra(N);
		
		System.out.println(dist.elementAt(K)[0]);
        System.out.println(dist.elementAt(K)[1]);
		
		
	}

}
