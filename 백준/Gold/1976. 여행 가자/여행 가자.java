import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt(), m=sc.nextInt();
	public static int[] parent=new int[N+1];
	public static int[] dis=new int[m];
	public static int[][] city=new int[N+1][N+1];
	public static int Find(int a) {
		if(parent[a]==a) return a;
		else {
			return parent[a]=Find(parent[a]);
		}
	}
	public static void Union(int x, int y) {
		x=Find(x); y=Find(y);
		if(x!=y) {
			parent[y]=x;
		}
	}
	public static void iscommit(int x, int y) {
		
		for(int i=1; i<m; i++) {
			x=Find(dis[0]); y=Find(dis[i]);
			if(x!=y) {
			System.out.println("NO");
			return;
		}
		}
		System.out.println("YES");
	}
	public static void main(String[] args) {
		
		for(int i=0; i<N; i++)parent[i]=i;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
			city[i][j]=sc.nextInt();
			if(city[i][j]==1) { Union(i, j);}
		}}
		for(int i=0; i<m; i++) {
			dis[i]=sc.nextInt();
		}
		iscommit(1, 0);
	}
}