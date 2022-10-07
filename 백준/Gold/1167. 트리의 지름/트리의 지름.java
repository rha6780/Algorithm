import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	
	public static ArrayList<ArrayList<Integer>> tr=new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> di=new ArrayList<ArrayList<Integer>>();
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static boolean[] visit=new boolean[100001];
	public static int[] dis=new int[100001];
	public static int Max=0, ss=0, sum=0;
	public static void rr(int a) {
		visit=new boolean[100001];
		dis=new int[100001];
		que.add(a);
		visit[a]=true;
		int p=0, y=0;
		while(!que.isEmpty()) {
			p=que.poll();
			for(int i=0; i<tr.get(p).size(); i++) {
				y=tr.get(p).get(i);
				if(visit[y]==false) {
				que.add(y);
				dis[y]=dis[p]+di.get(p).get(i);
				if(Max<dis[y]) {
					Max=dis[y]; ss=y;
				}
				visit[y]=true;}
			}
		}
		sum=Max;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<=T; i++) {
			tr.add(new ArrayList<Integer>());
			di.add(new ArrayList<Integer>());
		}
		for(int i=0; i<T; i++) {
			int o=sc.nextInt();
			int s=0;
			while(true) {
			s=sc.nextInt();
			if(s==-1) break;
			int d=sc.nextInt();
			tr.get(o).add(s);
			di.get(o).add(d);
			}
			
		}
		rr(1);
		sum=0; Max=0;
		rr(ss);
		System.out.println(sum);
	}

}