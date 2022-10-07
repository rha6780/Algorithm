import java.util.*;
public class Main {

	public static void BFS(int s,int u, int d, int g, int f){
		Queue<Integer> que=new LinkedList<Integer>();
		boolean[] visit=new boolean[f+1];
		visit[s]=true;
		int[] count=new int[f+1];
		que.add(s);
		count[s]=0;
		while(!que.isEmpty()){
			int x=que.poll();
			if(x==g){System.out.println(count[x]);return;}
			if(x+u>=1&&x+u<=f&&!visit[x+u]){que.add(x+u);count[x+u]=count[x]+1;visit[x+u]=true;}
			if(x-d>=1&&x-d<=f&&!visit[x-d]){que.add(x-d);count[x-d]=count[x]+1;visit[x-d]=true;}
		}
		System.out.println("use the stairs");
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int F=sc.nextInt(), S=sc.nextInt(), G=sc.nextInt(), U=sc.nextInt(), D=sc.nextInt();
		sc.close();
		BFS(S, U, D, G, F);

	}

}
