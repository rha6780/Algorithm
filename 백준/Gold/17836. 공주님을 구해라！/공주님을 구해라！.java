import java.util.*;
import java.io.*;

public class Main {
	
	
	public static boolean[][] visit = new boolean [105][105];
	public static int[][] times = new int[105][105];
	public static int[][] field = new int[105][105];
	public static int[] mover = {0,0,-1,1};
	public static int[] movec = {-1,1,0,0};
	
	public static void BFS(int r, int c) {
		visit[0][0] = true;
		times[0][0] = 0;
		Queue<Integer> quer = new LinkedList<Integer>();
		Queue<Integer> quec = new LinkedList<Integer>();
		quer.add(0);
		quec.add(0);
		while(!quer.isEmpty() && !quec.isEmpty()) {
			int tr = quer.poll();
			int tc = quec.poll();
			visit[tr][tc] = true;
			for (int i=0; i<4; i++) {
				int ar = tr+mover[i];
				int ac = tc+movec[i];
				if(ar>=0&&ar<r && ac>=0&&ac<c&&field[ar][ac] != 1) {
					if(!visit[ar][ac]) {
						times[ar][ac] = times[tr][tc]+1;
						visit[ar][ac] = true;
						quer.add(ar);
						quec.add(ac);
					}
				}
				
			}
					
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String scale = br.readLine();
		StringTokenizer st = new StringTokenizer(scale);
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int Time = Integer.parseInt(st.nextToken());
		String answer = "Fail";
		
		visit = new boolean[row][col];
		field = new int[row][col];
		times = new int[row][col];

		int gramr = 0;
		int gramc = 0;
		for(int i=0; i<row; i++) {
			String rows = br.readLine();
			st = new StringTokenizer(rows);
			for(int j=0; j<col; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				times[i][j] = Time+100;
				visit[i][j] = false;
				if (field[i][j] == 2) {
					gramr = i; gramc =j;
				}
			}
		}
		BFS(row, col);
		/*
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(times[i][j]);
			}
			System.out.println();
		}*/
		if (times[row-1][col-1] <= Time || (times[gramr][gramc]+Math.abs(row-gramr+col-gramc-2) <= Time)) {
			System.out.println( Math.min(times[row-1][col-1], (times[gramr][gramc]+Math.abs(row-gramr+col-gramc-2))));
		}
		else {
			System.out.println(answer);
		}
		
	}

}
