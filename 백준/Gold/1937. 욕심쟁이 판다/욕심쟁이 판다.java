import java.util.*;
public class Main {
	
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int[][] land=new int[N][N];
	public static boolean[][] visit=new boolean[N][N];
	public static int[][] count=new int[N][N];
	public static int[] dirx= {0,0,-1,1};
	public static int[] diry= {-1,1,0,0};
	public static int Max=0;
	public static void Dp(int x, int y) {
		visit[y][x]=true; count[y][x]=1;
		for(int i=0; i<4; i++) {
			int xx=x+dirx[i], yy=y+diry[i];
			if(xx>=0&&xx<N&&yy>=0&&yy<N) {
				if(land[y][x]<land[yy][xx]) {
					if(!visit[yy][xx]) {
						Dp(xx, yy);
					}
					if(count[y][x]<count[yy][xx]+1) {count[y][x]=count[yy][xx]+1;}
				}
			}
		}
		if(Max<count[y][x]) {Max=count[y][x];}
	}
	public static void main(String[] args) {

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				land[i][j]=sc.nextInt();
			}
		}
		sc.close();
		for(int k=0; k<N; k++) {
			for(int h=0; h<N; h++) {
				if(!visit[k][h]) {Dp(h,k);}
			}
		}
		System.out.println(Max);
	}

}
