import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
	public static int[] visit;
	public static int[] par;
	public static boolean dfs(int x) {
		if(visit[x]==1) {return false;}
		visit[x]=1;
		for(int i=0; i<arr.get(x).size(); i++) {
			int p=arr.get(x).get(i);
			if(par[p]==-1||dfs(par[p])) {
				par[p]=x;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		visit=new int[N+1];
		par=new int[N+1];
		for(int i=0; i<=N; i++) {arr.add(new ArrayList<Integer>());}
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
		}
		int result=0;
		Arrays.fill(par, -1);
		for(int i=1; i<=N; i++) {
			Arrays.fill(visit, 0);
			if(dfs(i)) {result++;}
		}
		System.out.println(result);
	}

}
