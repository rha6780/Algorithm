import java.util.*;
public class Main {

	public static boolean[] visit=new boolean[10000];
	public static int count=0;
	public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
	
	public static void BFS(int a){
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(a); visit[a]=true;
		while(!que.isEmpty()){
			int p=que.poll();
			for(int i=0; i<arr.get(p).size(); i++){
				int t=arr.get(p).get(i);
				if(visit[t]==false){
					visit[t]=true;
					que.add(t);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		
		for(int i=0; i<=N; i++){
			arr.add(new ArrayList<Integer>());
		}
		for(int i=0; i<M; i++){
			int a=sc.nextInt(); int b=sc.nextInt();
			arr.get(a).add(b); arr.get(b).add(a);
		}
		
		for(int i=1; i<=N; i++){
			if(visit[i]==false){BFS(i); count++;}
		}
		System.out.println(count);
	}

}
