import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int H=sc.nextInt();
	public static int N=sc.nextInt();
	public static int[] diry={0,0,-1,1};
	public static int[] dirx={-1,1,0,0};
	public static char[][] land=new char[H][N];
	public static boolean[][] visit=new boolean[H][N];
	public static int[][] count=new int[H][N];
	public static int Max=0;
	public static void BFS(int a, int b){
		Queue<Integer> quex=new LinkedList<Integer>();
		Queue<Integer> quey=new LinkedList<Integer>();
		quey.add(a); quex.add(b); 
		visit[a][b]=true; count[a][b]=0;
		while(!quey.isEmpty()&&!quex.isEmpty()){
			int ty=quey.poll(), tx=quex.poll();
			for(int i=0; i<4; i++){
				int yy=ty+diry[i], xx=tx+dirx[i];
				if(yy>=0&&yy<H&&xx>=0&&xx<N){
					if(!visit[yy][xx]&&land[yy][xx]=='L'){
						quey.add(yy);quex.add(xx);
						visit[yy][xx]=true; count[yy][xx]=count[ty][tx]+1;
						if(Max<=count[yy][xx]){Max=count[yy][xx];}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		sc.nextLine();
		for(int i=0; i<H; i++){
				String s=sc.nextLine();
				for(int j=0; j<N; j++){
					land[i][j]=s.charAt(j);
				}
		}
		
		for(int i=0; i<H; i++){
			for(int j=0; j<N; j++){
				visit=new boolean[H][N];
				count=new int[H][N];
				if(land[i][j]=='L'){BFS(i,j);}
			}
		}
		System.out.println(Max);

	}

}
