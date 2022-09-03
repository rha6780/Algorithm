import java.util.*;
public class Main {

	public static int[] mover={0,0,-1,1};
	public static int[] movec={-1,1,0,0};
	public static int N;
	public static int M;
	public static int[][] D;
	public static int[][] board;
	public static boolean[][] visit;
	
	public static int Dp(int x, int y){
		int tx=0; int ty=0; int t=0; visit[x][y]=true;
		if(x==N-1&&y==M-1){ D[x][y]=1;return 1;}
		for(int i=0; i<4; i++){
			tx=x+mover[i]; ty=y+movec[i];
			if(tx>=0&&ty>=0&&tx<N&&ty<M&&board[x][y]>board[tx][ty]){
				if(visit[tx][ty]==false){D[x][y]+=Dp(tx,ty);}
				else D[x][y]+=D[tx][ty];

			}
		}
		return D[x][y];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		D=new int[N][M]; visit=new boolean[N][M];
		board=new int[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				board[i][j]=sc.nextInt();
			}
		}
		int result=Dp(0,0);
		System.out.println(result);

	}

}
