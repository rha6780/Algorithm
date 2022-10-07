import java.util.*;
import java.io.*;
	
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] visit = new boolean[N+1][N+1];
		
		if(N!=1) {
		visit[1][N] = visit[N][1]=true;
		int count = N*(N-1)/2;
		int cur = 0;
		while(count-- >0) {
			for(int i=1; i<=N; i++) {
				if(cur == i || visit[cur][i]) {
					continue;
				}
				else {
					visit[cur][i]=true;
					visit[i][cur]=true;
					cur = i;
					break;
				}
			}
			System.out.print("a"+cur+" ");
		}
		}
		System.out.print("a1");

	}

}
