import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
	public static ArrayList<Edge> edgelist=new ArrayList<Edge>();
	public static int[] parent=new int[10001];
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
		int V=sc.nextInt(); int E=sc.nextInt();
		for(int i=0; i<V+1; i++){
			parent[i]=i;
		}
		int a=0, b=0, c=0;
		for(int j=0; j<E; j++){
			a=sc.nextInt(); b=sc.nextInt(); c=sc.nextInt();	
			edgelist.add(new Edge(a,b,c));	
		}	
		Collections.sort(edgelist);
		int sum=0;
		for(int i=0; i<edgelist.size(); i++){
			Edge ed=edgelist.get(i);
			if(!issameparent(ed.v1, ed.v2)){
				sum+=ed.cost;
				Union(ed.v1, ed.v2);
			}
		}
		System.out.println(sum);
	}

}
	class Edge implements Comparable<Edge>{
		int v1, v2, cost;
		 Edge(int v1, int v2,int cost){
			this.cost=cost; this.v1=v1; this.v2=v2;
		}
		 @Override
		 public int compareTo(Edge o){
			 if(this.cost<o.cost) return -1;
			 else if(this.cost==o.cost) return 0;
			 else return 1;
		 }
	}