import java.util.*;
public class Main {

	public static int[] ind=new int[40000];
	public static boolean[] visit=new boolean[40000];
	public static ArrayList<Integer>[] arr=new ArrayList[40000];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		for(int j=0; j<=N; j++){
			arr[j]=new ArrayList<>();
		}
		for(int i=0; i<M; i++){
			int a=sc.nextInt(); int b=sc.nextInt();
			arr[a].add(b); ind[b]++;
		}
		PriorityQueue<Integer> que=new PriorityQueue<Integer>();
		for(int h=1; h<=N; h++){
			if(ind[h]==0&&visit[h]==false){que.add(h); visit[h]=true;}
		while(!que.isEmpty()){
			int p=que.remove();
			visit[p]=true;
			System.out.print(p+" ");
			for(int i=0; i<arr[p].size(); i++){
				int t=arr[p].get(i); ind[t]--;
				if(ind[t]==0&&visit[t]==false){que.add(t); visit[h]=true;}
			}
		}
		}
	}

}
