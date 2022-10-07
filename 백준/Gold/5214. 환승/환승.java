import java.util.*;
public class Main {

	public static void main(String[] args) {
		Queue<Integer> que=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), K=sc.nextInt(), M=sc.nextInt();
		
		int[] count=new int[110001]; count[N]=1000000;
		boolean[] visit=new boolean[110001];
		ArrayList<ArrayList<Integer>> train=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<M+N+1; i++){train.add(new ArrayList<Integer>());}
		for(int i=0; i<M; i++){
			for(int h=0; h<K; h++){
				int hi=sc.nextInt();
				train.get(i+N+1).add(hi);
				train.get(hi).add(i+N+1);
				}
			}
		if(N==1){System.out.println(1); return;}
		
		que.add(1);count[1]=1;
		while(!que.isEmpty()){
			int tp=que.poll();
			if(visit[tp]==false){ visit[tp]=true;
			for(int i=0; i<train.get(tp).size(); i++){
				int p=train.get(tp).get(i);
				if(p==N){count[p]=Math.min(count[p], count[tp]+1); System.out.println(count[p]);return;}
				else if(p<N){que.add(p);count[p]=count[tp]+1;} else{que.add(p);count[p]=count[tp];}
			}}
		}
		System.out.println(-1);

	}

}
