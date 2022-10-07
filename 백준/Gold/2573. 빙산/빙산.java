import java.util.*;
import java.io.*;

public class Main {

	static int N, M, count, cnt;
	static int[][] field;
	static int[][] nextyear;
	static boolean[][] visit;
	static int[] movex = {0,0,-1,1};
	static int[] movey = {-1,1,0,0};
	
	static void BFS(int sx, int sy) {
		Queue<Integer> quex = new LinkedList<Integer>();
		Queue<Integer> quey = new LinkedList<Integer>();
		quex.add(sx); quey.add(sy);
		visit[sx][sy] = true;
		cnt=0;
		while(!quex.isEmpty()&&!quey.isEmpty()) {
			int tx = quex.poll();
			int ty = quey.poll();
			int meltcnt=0;
			cnt++;
			for(int i=0; i<4; i++) {
				int px = tx+movex[i];
				int py = ty+movey[i];
				if(px>=0&&py>=0&&px<N&&py<M) {
					if(field[px][py]==0) {
						meltcnt++;
					}
					else {
					if(!visit[px][py]) {
						visit[px][py]=true;
						quex.add(px); quey.add(py);
					}
					}
				}
			}
			nextyear[tx][ty]=field[tx][ty]-meltcnt;
			if(nextyear[tx][ty]<=0) {
				nextyear[tx][ty]=0;
				count--;
			}
			
		}
		quex.clear(); quey.clear();
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		nextyear = new int[N][M];
		visit = new boolean[N][M];
		count=N;
		
		int sx=0, sy=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				nextyear[i][j] = field[i][j];
			}
		}
		int result=0;
		while(count!=0) {
			sx=0; sy=0; count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					field[i][j]=nextyear[i][j];
					if(i==0||i==N-1||j==0||j==M-1) {
						field[i][j]=0;
					}
					
					if(field[i][j]!=0) {
						count++;
						//System.out.println(i+" "+j+" "+field[i][j]);
						visit[i][j]=false;
						if(sx==0&&sy==0) {
							sx=i;
							sy=j;
							//System.out.println(sx+" "+sy);
						}
					}
					else {
						visit[i][j]=true;
					}
				}
			}
			int c=count;
			BFS(sx, sy);
			//System.out.println(count+" "+cnt+" "+c);
			if(count>0&&cnt==c) {
				cnt=0; result+=1;
				//System.out.println(result);
			}
			else {
				break;
			}
			//System.out.println(result+" "+count);
		}
		if(count==0) {
			System.out.println(0);
		}
		else {
			System.out.println(result);
		}
		
		

	}

}
