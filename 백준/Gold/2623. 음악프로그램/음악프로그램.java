import java.util.*;
public class Main {

	public static int[] par=new int[5000];
	public static boolean[] visit=new boolean[5000];
	public static int find(int x){
		if(par[x]==x) return x;
		else{
			return par[x]=find(par[x]);
		}
	}
	public static void link(int x, int y){
		par[find(y)]=find(x);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		int[] siz=new int[N+1];
		for(int i=0; i<=N; i++){
			arr.add(new ArrayList<Integer>());
			par[i]=i;
		}
		for(int i=0; i<M; i++){
			int a=sc.nextInt();
			int[] tmp=new int[a];
			for(int k=0; k<a; k++){
				tmp[k]=sc.nextInt();
				if(k>0){arr.get(tmp[k-1]).add(tmp[k]); siz[tmp[k]]++;}
				
			}
		}
		Queue<Integer> que=new LinkedList<Integer>();
		for(int i=1; i<=N; i++){
			if(siz[i]==0){que.add(i); visit[i]=true;}
		}
		String s="";
		while(!que.isEmpty()){
			int t=que.remove();
			s+=t+"\n";
			for(int i=0; i<arr.get(t).size(); i++){
				int h=arr.get(t).get(i); siz[h]--;
				//if(par[t]==par[h]){s="0"; break;}
				if(siz[h]==0){que.add(h);link(t,h); visit[h]=true;}
			}
		}
		for(int i=1; i<=N; i++){
			if(visit[i]==false){s="0"; break;}
		}
		System.out.println(s);
		
	}

}
