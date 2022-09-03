import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	public static ArrayList<ArrayList<Integer>> rumor=new ArrayList<ArrayList<Integer>>();
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static boolean[] visit;
	public static int[] cnt;
	public static int[] rumm;
	public static int[] rum;
	public static int[] result;

	public static int time=0;
	public static void DBFS() {
		
		while(!que.isEmpty()) {
			int t=que.poll();
			int[] flag=new int[rumor.get(t).size()];
			for(int i=0; i<rumor.get(t).size(); i++) {
				int p=rumor.get(t).get(i); 
				rumm[p]++;
					if(visit[p]==false&&((cnt[p]%2==0&&rumm[p]>=cnt[p]/2)||(cnt[p]%2==1&&rumm[p]>=cnt[p]/2+1))) {
						visit[p]=true;
						flag[i]=1;que.add(p);
					}
			}
			for(int i=0; i<rumor.get(t).size(); i++) {
				int p=rumor.get(t).get(i);
					if(flag[i]==1) {
						if(result[p]==-1) {result[p]=result[t]+1;}
						else {result[p]=Math.min(result[p], result[t]+1);}}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		result=new int[N+2];
		visit=new boolean[N+2];
		cnt=new int[N+2]; rumm=new int[N+2]; rum=new int[N+2];
		for(int i=1; i<=N+1; i++) {
			rumor.add(new ArrayList<Integer>());
			result[i]=-1;
		}
		for(int i=1; i<=N; i++) {
			int a=1;
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(a!=0) {
				a=Integer.parseInt(st.nextToken());
				if(a==0) {cnt[i]=rumor.get(i).size();break;} 
				else {rumor.get(i).add(a);}
				}
				
		}
		int M=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] talk=new int[M];
		for(int i=0; i<M; i++) {
			int a=Integer.parseInt(st.nextToken());
			result[a]=0;
			talk[i]=a;
			que.add(a); visit[a]=true;
			/*for(int j=0; j<rumor.get(a).size(); j++) {
				rumm[rumor.get(a).get(j)]++;
			}*/
		}
		DBFS();
		for(int i=1; i<=N; i++) {
			bw.write(result[i]+" ");
		}
		bw.flush();
		
	}

}

