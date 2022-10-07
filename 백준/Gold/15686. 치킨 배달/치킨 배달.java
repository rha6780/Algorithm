import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class node{
	int ind=0; int[][] dis; int x=0; int y=0;
	public node(int ind, int n, int x, int y){
		this.ind=ind; this.dis=new int[n][n]; this.x=x; this.y=y;
	}
}
public class Main {
	
	public static int[] movex={0,0,-1,1};
	public static int[] movey={-1,1,0,0};
	public static int N;
	public static int M;
	public static int[][] d=new int[N][N];
	public static boolean[][] visited=new boolean[N][N];
	public static ArrayList<node> arr=new ArrayList<node>();
	public static ArrayList<Integer> ar=new ArrayList<Integer>();
	public static int[] visit=new int[M];
	public static int[][] min=new int[N][N];
	public static int[] sum=new int[100000000];
	public static int ii=0;
	
	public static void BFS(int a, int b, int c){
		Queue<Integer> quex=new LinkedList<Integer>();
		Queue<Integer> quey=new LinkedList<Integer>();
		int[][] distance=new int[N][N];
		quex.add(a); quey.add(b); visited[a][b]=true;
		while(!quex.isEmpty()&&!quey.isEmpty()){
			int t1=quex.poll(); int t2=quey.poll();
			for(int i=0; i<4; i++){
				int v1=t1+movex[i]; int v2=t2+movey[i];
				if(v1>=0&&v1<N&&v2>=0&&v2<N&&visited[v1][v2]==false){
					visited[v1][v2]=true;
					quex.add(v1); quey.add(v2);
					if(d[v1][v2]==1){
						distance[v1][v2]=Math.abs(a-v1)+Math.abs(b-v2);
						arr.get(c).dis[v1][v2]=distance[v1][v2];}
				}
			}
		}
		
	}
	
	public static void choose(int l, int C, int a){
		if(l==M){
			min=new int[N][N];
			for(int i=0; i<ar.size(); i++){
				visited=new boolean[N][N];
				BFS(arr.get(ar.get(i)).x,arr.get(ar.get(i)).y,ar.get(i));
				for(int k=0; k<N; k++){
					for(int h=0; h<N; h++){
						min[k][h]=Integer.MAX_VALUE;
					}
				}
				
			}
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(d[i][j]==1){
						
						for(int h=0; h<ar.size(); h++){
							if(min[i][j]>arr.get(ar.get(h)).dis[i][j]){min[i][j]=arr.get(ar.get(h)).dis[i][j];}
						}
						sum[ii]+=min[i][j];
					}
					
				}
			}
			ii++;
		}
		for(int i=0; i<C; i++){
			if(visit[i]!=0) continue;
				if(i>=a){
				visit[i]=1;
				ar.add(i);
				choose(l+1,C,i);
				visit[i]=0;
				ar.remove(ar.size()-1);
				}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
		d=new int[N][N]; visited=new boolean[N][N]; min=new int[N][N];
		for(int i=0; i<N; i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				d[i][j]=Integer.parseInt(st.nextToken());
				if(d[i][j]==2){arr.add(new node(count,N,i,j));count++;}
				min[i][j]=Integer.MAX_VALUE;
			}
		}
		visit=new int[count];
		choose(0,count, 0);
		int Min=Integer.MAX_VALUE;
		for(int i=0; i<ii; i++){
			if(Min>sum[i]){Min=sum[i];}
		}
		
		System.out.println(Min);
	}

}
