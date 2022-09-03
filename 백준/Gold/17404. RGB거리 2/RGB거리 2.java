import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] home;
	static int[][][] cost;
	

	static int DP(int a, int c, int s) {
		int min = Integer.MAX_VALUE;
		if(a==0) {
			min = Math.min(DP(a+1, 0, 0), Math.min(DP(a+1, 1, 1), DP(a+1, 2, 2)));
		}
		else if(a==N-1) {
			for(int i=0; i<3; i++) {
				if(i!=s) {
					cost[a][i][s]=home[a][i]+home[0][s];
				}
			}
		}
		else {
			if(cost[a+1][0][s]==Integer.MAX_VALUE) {
				DP(a+1, 1, s);
			} 
			if(cost[a+1][1][s]==Integer.MAX_VALUE) {
				DP(a+1, 2, s);
			} 
			if(cost[a+1][2][s]==Integer.MAX_VALUE) {
				DP(a+1, 0, s);
			} 
			if(c==0) {
				cost[a][1][s]=home[a][1]+Math.min(cost[a+1][0][s],cost[a+1][2][s]);
				cost[a][2][s]=home[a][2]+Math.min(cost[a+1][0][s],cost[a+1][1][s]);
				min=Math.min(cost[a][1][s], cost[a][2][s]);
			}
			else if(c==1) {
				cost[a][0][s]=home[a][0]+Math.min(cost[a+1][1][s],cost[a+1][2][s]);
				cost[a][2][s]=home[a][2]+Math.min(cost[a+1][0][s],cost[a+1][1][s]);
				min=Math.min(cost[a][0][s], cost[a][2][s]);
			}
			else {
				cost[a][0][s]=home[a][0]+Math.min(cost[a+1][1][s],cost[a+1][2][s]);
				cost[a][1][s]= home[a][1]+Math.min(cost[a+1][0][s],cost[a+1][2][s]);
				min=Math.min(cost[a][0][s],cost[a][1][s]);
			}

			//System.out.println(a+" "+c+" "+s+" "+min);

		}
		
		return min;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		N = Integer.parseInt(br.readLine());
		
		home = new int[N][3];
		cost = new int[N][3][3];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			home[i][0] =Integer.parseInt(st.nextToken());
			home[i][1] =Integer.parseInt(st.nextToken());
			home[i][2] =Integer.parseInt(st.nextToken());
			cost[i][0][0]=cost[i][1][0]=cost[i][2][0]=Integer.MAX_VALUE;
			cost[i][0][1]=cost[i][1][1]=cost[i][2][1]=Integer.MAX_VALUE;
			cost[i][0][2]=cost[i][1][2]=cost[i][2][2]=Integer.MAX_VALUE;
		}
		
		bw.append(""+DP(0,0,0));
		bw.flush();
		
	}

}
