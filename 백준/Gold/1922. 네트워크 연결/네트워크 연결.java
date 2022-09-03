import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Edge implements Comparable<Edge>{
	int v1, v2, cost;
	Edge(int v1, int v2,int cost){
		this.v1=v1; this.v2=v2; this.cost=cost;
	}
	@Override
	public int compareTo(Edge o){
		if(this.cost<o.cost) return -1;
		else if(this.cost==o.cost) return 0;
		else return 1;
	}
}
public class Main {
	public static ArrayList<Edge> edgelist=new ArrayList<Edge>();
	public static int[] parent=new int[1001];
	public static int Find(int x){
		if(parent[x]==x) return x;
		else return parent[x]=Find(parent[x]);
	}
	public static void Union(int x, int y){
		x=Find(x); y=Find(y);
		if(x!=y){
			parent[y]=x;
		}
	}
	public static boolean issameparent(int x, int y){
		x=Find(x); y=Find(y);
		if(x==y) return true;
		else return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		for(int i=0; i<N; i++) parent[i]=i;
		for(int i=0; i<M;i++){
			int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt();
			edgelist.add(new Edge(a, b, c));
		}
		Collections.sort(edgelist);
		int sum=0;
		for(int j=0; j<M; j++){
			Edge ee=edgelist.get(j);
			if(!issameparent(ee.v1, ee.v2)){
				sum+=ee.cost;
				Union(ee.v1, ee.v2);
			}
		}
		System.out.println(sum);
	}

}