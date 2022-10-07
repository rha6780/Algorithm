import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int n=sc.nextInt();
	public static int m=sc.nextInt();
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static ArrayList<ArrayList<Integer>> friend=new ArrayList<ArrayList<Integer>>();
	public static int count=0, hh=0;
	public static boolean[] visit=new boolean[n+1];
	public static void bfs() {
		que.add(1);visit[1]=true;
		while(!que.isEmpty()) {
			int kk=que.poll();
			for(int i=0; i<friend.get(kk).size(); i++) {
				if(kk==1&&!visit[friend.get(kk).get(i)]) { 
					que.add(friend.get(kk).get(i)); count++;
					visit[friend.get(kk).get(i)]=true;
			}
				else if(!visit[friend.get(kk).get(i)])count++;visit[friend.get(kk).get(i)]=true; 
				}
			
		}
	}
	public static void main(String[] args) {
		
		for(int i=0; i<n+1; i++) {
			friend.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int a=sc.nextInt(); int b=sc.nextInt();
			friend.get(a).add(b); friend.get(b).add(a);
		}
		bfs();
		System.out.println(count);

	}

}