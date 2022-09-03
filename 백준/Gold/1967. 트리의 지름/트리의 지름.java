import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static ArrayList<ArrayList<Integer>> tr=new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> di=new ArrayList<ArrayList<Integer>>();
	public static boolean[] visit=new boolean[10001];
	public static int Max=0, sit=0, Sum=0;
	public static Queue<Integer> que=new LinkedList<Integer>();
	
	public static void rr(int a) {
		visit=new boolean[N+1];
		int[] distance=new int[10001];
		que.add(a);
		visit[a]=true;
		int p=1;
		while(!que.isEmpty()) {
			
			p=que.poll();
			
			for(int i=0; i<tr.get(p).size(); i++) {
				int y=tr.get(p).get(i);
				if(visit[y]==false) {
				que.add(y);
				distance[y]=distance[p]+di.get(p).get(i);
				if(Max<distance[y]) { Max=distance[y]; sit=y;}
				visit[y]=true;}
			}
		}
		Sum+=Max;
	}
	public static void main(String[] args) {
	
		for(int i=0; i<10001; i++) {
			tr.add(new ArrayList<Integer>());
			di.add(new ArrayList<Integer>());
		}
		int oo=0;
		for(int i=0; i<N-1 ;i++) {
			int o=sc.nextInt();
			int s=sc.nextInt();
			int d=sc.nextInt();

			tr.get(o).add(s);//연결된 자식 노드
			di.get(o).add(d);//같은 인덱스에 저장된 거리
			tr.get(s).add(o);
			di.get(s).add(d);
			oo=o;
		}
		rr(1);
		Sum=0;Max=0;
		rr(sit);
		
		sc.close();
		System.out.println(Max);
	}

}