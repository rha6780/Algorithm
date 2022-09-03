import java.util.*;
public class Main {
	public static int[] fc=new int[100];
	public static ArrayList<ArrayList<Integer>> ff=new ArrayList<ArrayList<Integer>>();
	public static void BFS(int a) {
		int[] ffc=new int[100];
		boolean[] visit=new boolean[100];
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(a); visit[a]=true;ffc[0]=0;
		while(!que.isEmpty()) {
			int t=que.poll();
			for(int i=0; i<ff.get(t).size(); i++) {
				int p=ff.get(t).get(i);
				if(visit[p]==false) {
					visit[p]=true;
					que.add(p);
					ffc[p]=ffc[t]+1;
					if(ffc[p]<=2) {fc[a]++;}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {ff.add(new ArrayList<Integer>());}
		String[] friends=new String[N];
		for(int i=0; i<N; i++) {
			friends[i]=sc.next();
			for(int j=0; j<N; j++) {
				char aa=friends[i].charAt(j);
				if(aa=='Y') {
					ff.get(i).add(j);
				}
			}
		}
		
		int Max=0;
		for(int i=0; i<N; i++) {
			BFS(i);
			if(Max<fc[i]) {Max=fc[i];}
		}
		System.out.println(Max);
	}

}
