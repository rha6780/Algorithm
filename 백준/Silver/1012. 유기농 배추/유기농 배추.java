import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int T=sc.nextInt();
	public static int M=0, N=0, K=0, c=0;
	public static int[] count=new int[T];
	public static boolean[][] location=new boolean[M][N];
	public static boolean[][] visit=new boolean[M][N];
	public static Queue <Integer> quer=new LinkedList<Integer>();
	public static Queue <Integer> quec=new LinkedList<Integer>();
	
	public static void BFS(int k, int g) {
		visit[k][g]=true;
		quec.add(k);
		quer.add(g);
		while(!quer.isEmpty()&&!quec.isEmpty()) {
			int ii=quec.poll();
			int jj=quer.poll();
			if(ii+1<N&&location[ii+1][jj]==true&&!visit[ii+1][jj]) {visit[ii+1][jj]=true; quec.add(ii+1); quer.add(jj);}
			if(ii-1>=0&&location[ii-1][jj]==true&&!visit[ii-1][jj]) {visit[ii-1][jj]=true; quec.add(ii-1); quer.add(jj);}
			if(jj+1<M&&location[ii][jj+1]==true&&!visit[ii][jj+1]) {visit[ii][jj+1]=true; quec.add(ii); quer.add(jj+1);}
			if(jj-1>=0&&location[ii][jj-1]==true&&!visit[ii][jj-1]) {visit[ii][jj-1]=true; quec.add(ii); quer.add(jj-1);}
		}
		count[c]++;
	}
	public static void main(String[] args) {
		
		for(int i=0; i<T; i++) {
			M=sc.nextInt(); N=sc.nextInt(); K=sc.nextInt();
			location=new boolean[N][M];
			visit=new boolean[N][M];
			for(int j=0; j<K; j++) {
					int a=sc.nextInt();
					int b=sc.nextInt();
					location[b][a]=true;
			}
			
			for(int j=0; j<N; j++) {
				for(int h=0; h<M; h++) {
					if(location[j][h]==true&&!visit[j][h]) {
						BFS(j, h);
					}
				}
			}
			
			System.out.println(count[i]);
			c++;
		}

	}

}