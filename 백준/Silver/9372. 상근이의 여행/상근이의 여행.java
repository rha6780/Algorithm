import java.util.*;

class Node implements Comparable<Node>{
	int x, y, z;
	public Node(int x, int y, int z) {
		this.x=x; this.y=y; this.z=z;
	}
	@Override
	public int compareTo(Node arg0) {
		return this.z-arg0.z;
	}
}
public class Main {
	
	static int[] uf;
	public static int disjoint(int x) {
		if(uf[x]!=x) return uf[x]=disjoint(uf[x]);
		else return x;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			uf=new int[N+1];
			for(int j=0; j<=N; j++) {uf[j]=j;}
			ArrayList<Node> Edges=new ArrayList<Node>();
			for(int j=0; j<M; j++) {
				Edges.add(new Node(sc.nextInt(), sc.nextInt(), 1));
			}
			Collections.sort(Edges);
			long ans=0;
			for(int h=0; h<M; h++) {
				int x=Edges.get(h).x, y=Edges.get(h).y, z=Edges.get(h).z;
				if(disjoint(x)!=disjoint(y)) {
					uf[disjoint(y)]=disjoint(x);
					ans+=z;
				}
			}
			System.out.println(ans);
		}

	}

}
