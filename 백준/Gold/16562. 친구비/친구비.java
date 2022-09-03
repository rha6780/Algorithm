import java.util.*;
import java.io.*;
public class Main {

	public static int[] cost=new int[10001];
	public static int[] par=new int[10001];
	public static int[] rank=new int[10001];

	public static int find(int x){
		if(x==par[x]) return x;
		else{
			return par[x]=find(par[x]);
		}
	}
	
	public static void Union(int x, int y){
		x=find(x); y=find(y); //각 부모를 찾고
		if(x==y){return;} //같은 그룹이면 return
		else{ //다르면 작은 그룹을 큰그룹에 속하게 한다.
			if(cost[x]<cost[y]){int tmp=x; x=y; y=tmp; }
			//System.out.println(cost[x]+" "+cost[y]+" "+x+" "+y);
			par[x]=y; //그룹의 원 부모만 바꾸면 그 그룹의 자식들도 같은 부모를 가지게 된다.
			//if(rank[x]==rank[y]) ++rank[y];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String r=br.readLine();
		StringTokenizer st=new StringTokenizer(r);
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		String s=br.readLine();
		st=new StringTokenizer(s);
		for(int i=0; i<N; i++){
			cost[i]=Integer.parseInt(st.nextToken());
			//rank[i]=1;
			par[i]=i;
		}
		for(int j=0; j<M; j++){
			String sr=br.readLine();
			st=new StringTokenizer(sr);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			Union(a-1,b-1);
		}
		int[] visit=new int[N];
		int Sum=0;
		for(int j=0; j<N; j++){
			int u=find(j);
			if(visit[u]==0){Sum+=cost[u]; visit[u]=1;}
		}
		if(Sum<=K){System.out.println(Sum);}
		else{System.out.println("Oh no");}
	}

}
