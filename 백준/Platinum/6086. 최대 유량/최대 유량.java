import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt(), INF=999999999, result=0;
	public static int[][] c=new int[52][52];
	public static int[][] f=new int[52][52];
	public static int[] d=new int[52];
	public static ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();

	public static void maxflow(int s, int e) {
		while(true) {
			Queue<Integer> que=new LinkedList<Integer>();
			d=new int[52];
			for(int i=0; i<52; i++) {d[i]=-1;}
			que.add(s);
			while(!que.isEmpty()) {
				int t=que.poll();
				for(int i=0; i<a.get(t).size(); i++) {
					
					int y=a.get(t).get(i);
					if(c[t][y]-f[t][y]>0&&d[y]==-1) {
						que.add(y);
						d[y]=t;
						if(y==e)break;
					}
				}
			}
			if(d[e]==-1) break;
			int flow=INF;
			for(int i=e; i!=s; i=d[i]) {
				flow=Math.min(flow, (c[d[i]][i]-f[d[i]][i]));
			}
			for(int i=e; i!=s; i=d[i]) {
				f[d[i]][i]+=flow;
				f[i][d[i]]-=flow;
			}
			result+=flow;
		}
	}
	public static void main(String[] args) {
		for(int j=0; j<52; j++) {
			a.add(new ArrayList<Integer>());
		}
		for(int i=0; i<N; i++) {
			String a1=sc.next();char t1=a1.charAt(0);
			String b1=sc.next();char t2=b1.charAt(0);
			int tt1=0, tt2=0;
			if('a'<=t1&&t1<='z') {tt1=(int)(t1-'a')+26;}
			else {tt1=(int)(t1-'A');}
			if('a'<=t2&&t2<='z') {tt2=(int)(t2-'a')+26;}
			else {tt2=(int)(t2-'A'); }
			int cc=sc.nextInt();

			a.get(tt1).add(tt2);
			a.get(tt2).add(tt1);
			c[tt1][tt2]=c[tt2][tt1]+=cc;
		}
		maxflow(0, 25);
		System.out.println(result);
	}
}
