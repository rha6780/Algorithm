import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static ArrayList<ArrayList<Integer>> friend=new ArrayList<ArrayList<Integer>>();
	public static int[][] depth=new int[102][102];
	public static boolean[][] con=new boolean[102][102];
	
	public static void BFS(int n) {
		Queue<Integer> que=new LinkedList<Integer>();
		for(int h=1; h<=n; h++) {
			con=new boolean[102][102];
			depth=new int[102][102];
			que.add(h);
		while(!que.isEmpty()) {
			int t=que.poll();
			
			for(int i=0; i<friend.get(t).size(); i++) {
				int p=friend.get(t).get(i);
				if(depth[h][p]!=0&&depth[h][p]>depth[h][t]+1){depth[h][p]=depth[h][t]+1;}
				if(con[t][p]==false&&con[p][t]==false) {
					que.add(p);
					depth[h][p]=depth[h][t]+1;
					con[t][p]=con[p][t]=true;
					con[h][p]=con[p][h]=true;
				}
			}
		}
		for(int j=1; j<=n; j++) {
			if(h!=j) {
				if(depth[h][j]>6) {System.out.println("Big World!"); return;}
				if(con[h][j]==false) {System.out.println("Big World!"); return;}
			}
		}
	}
		System.out.println("Small World!");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(); int b=sc.nextInt();
		for(int i=0; i<a+1; i++) {
			friend.add(new ArrayList<Integer>());
		
		}
		for(int j=0; j<b; j++) {
			int x=sc.nextInt(), y=sc.nextInt();
			friend.get(x).add(y);friend.get(y).add(x);
			
		}
		BFS(a);
	}

}
