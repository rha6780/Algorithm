import java.util.*;
public class Main {

	public static void main(String[] args) {
		Queue<Integer> que=new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> fam=new ArrayList<ArrayList<Integer>>();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int a=sc.nextInt(), b=sc.nextInt();
		boolean[] visit=new boolean[N+1];
		int[] count=new int[N+1];
		for(int i=0; i<N+1; i++){
			fam.add(new ArrayList<Integer>());
		}
		int M=sc.nextInt();
		for(int i=0; i<M; i++){
			int c=sc.nextInt(), d=sc.nextInt();
			fam.get(c).add(d);
			fam.get(d).add(c);
		}
		visit[a]=true;
		que.add(a);
		while(!que.isEmpty()){
			int t=que.poll();
			for(int i=0; i<fam.get(t).size(); i++){
				int p=fam.get(t).get(i);
				if(visit[p]==false){que.add(p);count[p]=count[t]+1;visit[p]=true;}
				if(p==b){break;}
			}
		}
		if(count[b]!=0)System.out.println(count[b]);
		else{System.out.println(-1);}

	}

}
