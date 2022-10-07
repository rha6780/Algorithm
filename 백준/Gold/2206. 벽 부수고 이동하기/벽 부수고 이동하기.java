import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static int[][] map; 
	public static boolean[][][] visit;
	public static int[][][] count;
	public static int[] mover = {0,0,-1,1};
	public static int[] movec = {-1,1,0,0};
	
	public static void BFS(int a, int b) {
		visit[a][b][1]=true;
		visit[a][b][0]=true;
		count[a][b][1]=1;
		count[a][b][0]=1;
		Queue<Integer> quer = new LinkedList<Integer>();
		Queue<Integer> quec = new LinkedList<Integer>();
		Queue<Integer> queb = new LinkedList<Integer>();
		quer.add(a);
		quec.add(b);
		queb.add(1);
		
		while(!quer.isEmpty()&&!quec.isEmpty()&&!queb.isEmpty()) {
			int r = quer.poll();
			int c = quec.poll();
			int bb = queb.poll();
			for(int i=0; i<4; i++) {
				int tr = r+mover[i];
				int tc = c+movec[i];
				if(tr>=0&&tr<N&&tc>=0&&tc<M&&bb>=0&&!visit[tr][tc][bb]) {
					if(map[tr][tc]!=1) {
						visit[tr][tc][bb]=true;
						count[tr][tc][bb]=Math.min(count[tr][tc][bb], count[r][c][bb]+1);
						quer.add(tr);
						quec.add(tc);
						queb.add(bb);
					}
					else { //벽을 부수는 경우.
						if(bb==1) {
							int b1=bb-1;
							visit[tr][tc][b1]=true;
							count[tr][tc][b1]=Math.min(count[tr][tc][b1], count[r][c][bb]+1);
							quer.add(tr);
							quec.add(tc);
							queb.add(b1);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M][2];
		count = new int[N][M][2];
		
		
		for(int i=0; i<N; i++) {
			String a =br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(a.charAt(j)-'0'+"");
				count[i][j][0]=Integer.MAX_VALUE;
				count[i][j][1]=Integer.MAX_VALUE;
			}
		}
		
		BFS(0,0);
		
		
		if(count[N-1][M-1][0]==Integer.MAX_VALUE&&count[N-1][M-1][1]==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(Math.min(count[N-1][M-1][0], count[N-1][M-1][1]));
		}
		
	}

}
