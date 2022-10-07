import java.util.*;

class Node implements Comparable<Node>{
	int x,y,z;
	public Node(int x, int y, int z){
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
		if(uf[x]!=x) {return uf[x]=disjoint(uf[x]);}
		else return x;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		uf=new int[N+1];
		ArrayList<Node> Edge=new ArrayList<Node>();
		for(int i=0; i<=N; i++) {uf[i]=i;}
		for(int i=0; i<M; i++) {
			Edge.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(Edge);
		long ans=0;
		long max=0;
		for(int i=0; i<M; i++) {
			int x=Edge.get(i).x, y=Edge.get(i).y, z=Edge.get(i).z;
			if(disjoint(x)!=disjoint(y)) {
				uf[disjoint(y)]=uf[x];
				ans+=z;
				if(z>max) {max=z;}
			}
		}
		System.out.println(ans-max);
	}

}
