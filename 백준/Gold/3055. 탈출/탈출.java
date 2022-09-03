import java.util.*;
public class Main {

	public static int R, C;
	public static char[][] field=new char[100][100];
	public static int[][] wtime=new int [60][60];
	public static int[][] time=new int[60][60];
	public static boolean[][] visit=new boolean[60][60];
	public static boolean[][] wvisit=new boolean[60][60];
	public static int[] movex={0,0,-1,1};
	public static int[] movey={1,-1,0,0};
	
	public static void BFS(int x, int y, int fx, int fy){
		Queue<Integer> quex=new LinkedList<Integer>();
		Queue<Integer> quey=new LinkedList<Integer>();
		time[x][y]=0;
		quex.add(x); quey.add(y); visit[x][y]=true;
		while(!quex.isEmpty()&&!quey.isEmpty()){
			int tx=quex.poll(); int ty=quey.poll();
			
			for(int i=0; i<4; i++){
				int px=tx+movex[i]; int py=ty+movey[i];
				if(px>=0&&px<R&&py>=0&&py<C&&visit[px][py]==false&&time[tx][ty]+1<wtime[px][py]&&(field[px][py]=='.'||field[px][py]=='D')){
					quex.add(px); quey.add(py);
					visit[px][py]=true;
					time[px][py]=time[tx][ty]+1;
					if(px==fx&&py==fy){System.out.println(time[fx][fy]);return;}
				}
			}
					
		}
		System.out.println("KAKTUS");
	}
	public static Queue<Integer> quex=new LinkedList<Integer>();
	public static Queue<Integer> quey=new LinkedList<Integer>();
	public static void wBFS(){

		while(!quex.isEmpty()&&!quey.isEmpty()){
			int tx=quex.poll(); int ty=quey.poll();
			for(int i=0; i<4; i++){
				int px=tx+movex[i]; int py=ty+movey[i];
				if(px>=0&&px<R&&py>=0&&py<C&&wvisit[px][py]==false&&field[px][py]=='.'){
					quex.add(px); quey.add(py);
					wvisit[px][py]=true;
					wtime[px][py]=wtime[tx][ty]+1;
				}
			}
					
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		field=new char[R][C];
		time=new int[R][C];
		wtime=new int[R][C];
		visit=new boolean[R][C];
		wvisit=new boolean[R][C];

		int sx=0, sy=0;
		int fx=0, fy=0;

		for(int i=0; i<R; i++){
			String s=sc.next();
			field[i]=s.toCharArray();
			for(int j=0; j<C; j++){
				if(field[i][j]=='S'){sx=i; sy=j;}
				if(field[i][j]=='D'){fx=i; fy=j; wtime[i][j]=100000;}
				if(field[i][j]=='*'){quex.add(i); quey.add(j); wvisit[i][j]=true;wtime[i][j]=0;}
				if(field[i][j]=='.'){wtime[i][j]=1000000;}
			}
		}
		wBFS();
		BFS(sx, sy, fx, fy);
	}

}
