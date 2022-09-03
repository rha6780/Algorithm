import java.io.*;
import java.util.*;

public class Main {
	
	public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
	public static int[] par;
	public static int[] visit;
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
		int N=Integer.parseInt(br.readLine());
		int[][] shark=new int[N][3];
		par=new int[N];
		visit=new int [N];
		for(int i=0; i<N; i++) {
			arr.add(new ArrayList<Integer>());
			StringTokenizer st=new StringTokenizer(br.readLine());
			shark[i][0]=Integer.parseInt(st.nextToken());
			shark[i][1]=Integer.parseInt(st.nextToken());
			shark[i][2]=Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(shark[i][0]==shark[j][0]&&shark[i][1]==shark[j][1]&&shark[i][2]==shark[j][2]) {
					arr.get(i).add(j);
					//System.out.println(i+"->"+j);
				}
				else {
					if(shark[i][0]<=shark[j][0]&&shark[i][1]<=shark[j][1]&&shark[i][2]<=shark[j][2]) {
						arr.get(j).add(i);
						//System.out.println(j+"->"+i);
					}
					else if(shark[i][0]>=shark[j][0]&&shark[i][1]>=shark[j][1]&&shark[i][2]>=shark[j][2]) {
						arr.get(i).add(j);
						//System.out.println(i+"->"+j);	
					}
				}
			}
		}
		Arrays.fill(par, -1);
		int result=0;
		for(int i=0; i<N; i++) {
			Arrays.fill(visit, 0);
			//System.out.println("진행률:"+result);
			if(dfs(i)) {result++;}
		}
		for(int i=0; i<N; i++) {
			Arrays.fill(visit, 0);
			if(dfs(i)) {result++;}
		}
		System.out.println(N-result);
	}

}
