import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static int p=0, r=0, cc=0;
	public static int Min=1000000;
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int M=sc.nextInt();
	public static int[][] friend=new int[101][101];
	public static boolean[] visit=new boolean[101];
	public static int[] count=new int[101];
	public static Queue<Integer> que=new LinkedList<Integer>();
	
	public static void bfs(int i) {
		que.add(i);p=0;cc=1;
		visit[i]=true;
		while(!que.isEmpty()) {
			int k=que.poll();
			
			for(int h=0; h<101;h++) {
			if(friend[k][h]==1&&!visit[h]) { 
				if(k!=i)friend[i][h]+=friend[k][h]+friend[i][k];
				visit[h]=true;
				que.add(h);
				count[i]+=friend[i][h];
			}
			}			
		}
		if(count[i]>=N-1&&count[i]<Min) {
			r=i; Min=count[i];
			
		}
		else if(count[i]==Min) {
			if(r>i) r=i;
			else r=r;
		}
		
	}
	public static void main(String[] args) {
		
		for(int i=0; i<M; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			friend[a][b]=1;
			friend[b][a]=1;
		}
		for(int i=1; i<101; i++) {
			bfs(i);
			visit=new boolean[101];
		}
		System.out.println(r);
	}
}