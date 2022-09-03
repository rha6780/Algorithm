import java.util.*;
import java.io.*;


public class Main {

	static int N=0, M=0;
	static int[][] cell;
	static HashMap<Integer,Integer>[] jump;
	static boolean[][] visit;
	
	static void Dijkstra() {
		visit[1][1]=true;
		Queue<Integer> quex = new LinkedList<Integer>();
		Queue<Integer> quey = new LinkedList<Integer>();
		quex.add(1); quey.add(1);
		while(!quex.isEmpty()&&!quey.isEmpty()) {
			int nx = quex.poll();
			int ny = quey.poll();
			//System.out.println(nx+" "+ny+" "+cell[nx][ny]);
			if(cell[nx][ny]>N*M||jump[cell[nx][ny]]==null||jump[cell[nx][ny]].size()==0) continue;
			for(int i : jump[cell[nx][ny]].keySet()) {
				int px=i;
				int py=jump[cell[nx][ny]].get(i);
				if(px>0&&py>0&&px<=M&&py<=N) {
					if(!visit[px][py]) {
						//System.out.println(px+" "+py);
						visit[px][py]=true;
						quex.add(px);
						quey.add(py);
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		M=Integer.parseInt(br.readLine());
		N=Integer.parseInt(br.readLine());
		
		cell = new int[M+2][N+2];
		visit = new boolean[M+2][N+2];
		jump = new HashMap[(N+1)*(M+1)+1];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(visit[i], false);
			for(int j=1; j<=N; j++) {
				visit[i][j]=false;
				if(jump[i*j]==null) {
					jump[i*j]=new HashMap<Integer, Integer>();
				}
				cell[i][j]=Integer.parseInt(st.nextToken());
				jump[i*j].put(i, j);
			}
		}
		
		
		Dijkstra();
		if(visit[M][N]==false) {
			System.out.println("no");
		}
		else {
			System.out.println("yes");
		}

	}

}
