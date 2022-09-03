import java.util.Scanner;
public class Main {
	public static int[] parent=new int[1000001];
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
	public static void is(int x, int y) {
		x=Find(x); y=Find(y);
		if(x!=y) {
			System.out.println("NO");
		}
		else System.out.println("YES");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		for(int i=0; i<n+1; i++) {
			parent[i]=i;
		}
		for(int i=0; i<m; i++) {
			int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt();
			if(a==0) {
				Union(b,c);
			}
			else {
				is(b,c);
			}
		}
	}
}