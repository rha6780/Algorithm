import java.util.*;
public class Main {

	public static int[] par=new int[300002];
	public static boolean[] visit=new boolean[300002];
	public static int find(int x) {
		if(par[x]==x) return x;
		else return par[x]=find(par[x]);
	}
	public static void link(int x, int y) {
		par[find(y)]=find(x);
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int L=sc.nextInt();
		int count=0;
		int[][] store=new int[N][2];
		for(int i=0; i<=L; i++) {par[i]=i;}
		for(int i=0; i<N; i++) {
			store[i][0]=sc.nextInt();
			store[i][1]=sc.nextInt();
		}
		visit=new boolean[300002];
		for(int i=0; i<N; i++) {
			if(visit[store[i][0]]==false) {System.out.println("LADICA");visit[store[i][0]]=true; link(store[i][1], store[i][0]);}
			else if(visit[store[i][1]]==false) {System.out.println("LADICA");visit[store[i][1]]=true; link(store[i][0], store[i][1]);}
			else if(visit[find(store[i][0])]==false) { System.out.println("LADICA");visit[find(store[i][0])]=true;link(store[i][1], store[i][0]);}
			else if(visit[find(store[i][1])]==false) { System.out.println("LADICA");visit[find(store[i][1])]=true;link(store[i][0], store[i][1]);}
			else {System.out.println("SMECE");}
			
		}
		
	}

}
