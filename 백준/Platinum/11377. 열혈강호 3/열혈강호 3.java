import java.util.*;
import java.io.*;
public class Main {

	public static int N, M, K;
	public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();

	public static int[] par=new int[1000];
	public static int[] par2=new int[1000];
	public static int[] visit=new int[1000];
	public static int result=0;

	public static boolean dfs(int c) {
		if(visit[c]==1) return false;
		visit[c]=1;
		for(int i=0; i<arr.get(c).size(); i++) {
			int p=arr.get(c).get(i);
			if(par[p]==-1||dfs(par[p])) {
				par[p]=c;
				par2[c]=p;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		par=new int[M+N+2];
		par2=new int[M+N+2];
		visit=new int[M+N+2];
		for(int i=0; i<=N+M+1; i++) {arr.add(new ArrayList<Integer>());}
		for(int i=N+1; i<N+M+1;i++) {arr.get(i).add(N+M+1);}
		for(int i=1; i<=N; i++) {
			arr.get(0).add(i);
			st=new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			for(int j=0; j<c; j++) {
				int a=Integer.parseInt(st.nextToken());
				arr.get(i).add(N+a); //a는 할일
			}
		}
		Arrays.fill(par,-1);
		Arrays.fill(par2,-1);
		int r1=0;
		for(int i=1; i<N+1; i++) {
			Arrays.fill(visit,0);
			if(dfs(i))r1++;
		}
		int r2=0;
		for(int i=1; i<N+1; i++) {
			Arrays.fill(visit,0);
			if(dfs(i))r2++;
		}
		result=r1+Math.min(r2, K);
		System.out.println(result);
	}

}
