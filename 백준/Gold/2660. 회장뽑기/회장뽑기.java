import java.util.*;
import java.io.*;
public class Main {

	public static int[][] dist=new int[55][55];
	public static int[] count=new int[55];
	public static void floyd(int N) {
		for(int j=1; j<=N; j++) {
			for(int i=1; i<=N; i++) { //출발
			for(int h=1; h<=N; h++) { //도착
				 //중간
					if(dist[i][h]>dist[i][j]+dist[j][h]) {
						dist[i][h]=dist[i][j]+dist[j][h];
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		dist=new int[N+1][N+1];
		for(int i=0; i<=N; i++) {Arrays.fill(dist[i], 100); dist[i][i]=0;}
		int a=0; int b=0;
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			if(a==-1&& b==-1) {break;}
			else {
				dist[a][b]=1; dist[b][a]=1;
			}
		}
		floyd(N);
		int Min=Integer.MAX_VALUE;int cnt=0;
		for(int i=1; i<=N; i++) {
			for(int h=1; h<=N; h++) {
				count[i]=Math.max(count[i], dist[i][h]);
			}
			if(Min>count[i]) {Min=count[i]; cnt=1;}
			else if(Min==count[i]) {cnt++;}
		}
		

		System.out.println(Min+" "+cnt);
		for(int i=1; i<=N; i++) {
			if(Min==count[i]) {System.out.print(i+" ");}
		}
		
	}

}
