import java.util.*;
public class Main {
	public static char[][] borad=new char[101][101];
	public static int[][] move=new int[101][101];
	public static boolean[][] visit=new boolean[101][101];
	public static int[] rdir= {-1,1,0,0};
	public static int[] cdir= {0,0,-1,1};
	public static void BFS(int n, int m) {
		Queue<Integer> quer=new LinkedList<Integer>();
		Queue<Integer> quec=new LinkedList<Integer>();
		quer.add(0); quec.add(0);move[0][0]=1;visit[0][0]=true;
		while(!quer.isEmpty()&&!quec.isEmpty()) {
			int r=quer.poll(), c=quec.poll();
			for(int i=0; i<4; i++) {
				if(r+rdir[i]>=0&&c+cdir[i]>=0&&r+rdir[i]<n&&c+cdir[i]<m) {
					if(visit[r+rdir[i]][c+cdir[i]]==false&&borad[r+rdir[i]][c+cdir[i]]=='1') {
						quer.add(r+rdir[i]); quec.add(c+cdir[i]);
						visit[r+rdir[i]][c+cdir[i]]=true;
						if(move[r+rdir[i]][c+cdir[i]]==0)move[r+rdir[i]][c+cdir[i]]=move[r][c]+1;
						
					}
					
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		borad=new char[N][M];
		move=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0; i<N; i++) {
			String s=sc.next();
			borad[i]=s.toCharArray();
		}
		BFS(N,M);
		System.out.println(move[N-1][M-1]);
	}
}
