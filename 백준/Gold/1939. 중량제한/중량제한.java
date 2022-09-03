import java.util.*;
import java.io.*;
class road{
	int e, cost;
	public road(int e, int cost) {
		this.e=e; this.cost=cost;
	}
}
public class Main {

	public static int start=0, fin=0;
	public static int[] visit=new int[100001];
	public static boolean BFS(int cost) {
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(start); visit[start]=1;
		while(!que.isEmpty()) {
			int t=que.poll();
			if(t==fin) {return true;}
			for(int i=0; i<arr.get(t).size(); i++) {
				int p=arr.get(t).get(i).e;
				int c=arr.get(t).get(i).cost;
				if(visit[p]!=1 && cost<=c) { //건널수 있는가
					visit[p]=1;
					que.add(p);
				}
			}
		}
		return false;
	}
	public static ArrayList<ArrayList<road>> arr=new ArrayList<ArrayList<road>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		visit=new int[N+1];
		for(int i=0; i<=N; i++) {arr.add(new ArrayList<road>());}
		int r=0;
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			arr.get(a).add(new road(b,c));
			arr.get(b).add(new road(a,c));
			r=Math.max(r, c);
		}
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		fin=Integer.parseInt(st.nextToken());
		int l=1; int mid=0;
		int result=1;
		while(l<=r) {
			visit=new int[N+1];
			mid=(l+r)/2;
			if(BFS(mid)==true) {
				result=mid;
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		System.out.println(result);
	}

}
