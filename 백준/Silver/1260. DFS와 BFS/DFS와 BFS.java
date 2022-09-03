import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	
	public static boolean[] visit=new boolean[10000];
	public static ArrayList<ArrayList<Integer>> db=new ArrayList<ArrayList<Integer>>();
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static void DFS(int t) {
		visit[t]=true;
		System.out.print(t+" ");
		for(int i=0; i<db.get(t).size(); i++) {
			int o=db.get(t).get(i);
		if(visit[o]==false) {
			DFS(o);
		}
		}
	}
	
	public static void BFS(int t) {
		que.add(t);
		visit[t]=true;
		System.out.print(t+" ");
		while(!que.isEmpty()) {
			int p=que.poll();
			for(int i=0; i<db.get(p).size(); i++) {
				int o=db.get(p).get(i);
				if(visit[o]==false) {
					que.add(o);
					visit[o]=true;
					System.out.print(o+" ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int V=sc.nextInt();
		for(int i=0; i<1001; i++) {
			db.add(new ArrayList<Integer>());
		}
		int[][] num=new int[M][2];
		for(int i=0; i<M; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			db.get(a).add(b); db.get(b).add(a);
		}
		
	
		for(int i=0; i<N+1; i++) {
			int ss=db.get(i).size();
			int[] empty=new int[ss];
			for(int j=0; j<ss; j++) {
			empty[j]=db.get(i).get(j);
			}
			Arrays.sort(empty);
			db.get(i).clear();
			for(int j=0; j<ss; j++) {
				db.get(i).add(empty[j]);
			}
			
		}
		DFS(V);
		visit=new boolean[10000];
		System.out.println();
		BFS(V);
	}

}