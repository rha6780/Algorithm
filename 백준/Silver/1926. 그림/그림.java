import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static int N,M, MAX, COUNT;
	public static boolean[][] visit;
	public static int[][] field;
	public static int[] movex = {0,0,1,-1};
	public static int[] movey = {1,-1,0,0};
	
	public static void BFS(int a, int b) {
		int max = 1;
		
		COUNT++;
		Queue<Integer> quec = new LinkedList<Integer>();
		Queue<Integer> quer = new LinkedList<Integer>();
		quec.add(a);
		quer.add(b);
		visit[a][b]=true;
		
		while(!quer.isEmpty()&&!quec.isEmpty()) {
			int tc = quec.poll();
			int tr = quer.poll();
			for(int i=0; i<4; i++) {
				int pr = tr+movex[i];
				int pc = tc+movey[i];
				if(pr>=0&&pr<M && pc>=0&&pc<N&&visit[pc][pr]==false&&field[pc][pr]==1) {
					visit[pc][pr]=true;
					max++;
					quer.add(pr);
					quec.add(pc);
				}
			}
		}
		MAX = Math.max(MAX, max);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		field = new int[N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				field[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(field[i][j] == 1 && !visit[i][j]) {
					BFS(i, j);
				}
			}
		}
		System.out.println(COUNT);
		System.out.println(MAX);
	}

}
