import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	
	public static Queue<Integer> quex=new LinkedList<Integer>();
	public static Queue<Integer> quey=new LinkedList<Integer>();
	public static Queue<Integer> fx=new LinkedList<Integer>();
	public static Queue<Integer> fy=new LinkedList<Integer>();
	public static char[][] field;
	public static boolean[][] visit;
	public static boolean[][] visited;
	public static int[][] firetime;
	public static int[][] time;
	public static int[] movex= {0,0,1,-1};
	public static int[] movey= {1,-1,0,0};
	
	
	public static void BFS(int sx, int sy, int w, int h, int c) throws IOException {
		quex.add(sx); quey.add(sy);
		visit[sx][sy]=true; time[sx][sy]=0;
		int count=c; int gap=1; int cc=0;
		if(sx==0||sy==0||sx==w-1||sy==h-1) {System.out.println(time[sx][sy]+1); return;}
		fireBFS(c, w, h);
		while(!quex.isEmpty()&&!quey.isEmpty()) {
			int tx=quex.poll(); int ty=quey.poll();
			
			for(int i=0; i<4; i++) {
				int px=tx+movex[i]; int py=ty+movey[i];
				if(px>=0&&px<=w-1&&py>=0&&py<=h-1&&visit[px][py]==false&&field[px][py]=='.'&&(firetime[px][py]>time[tx][ty]+1||firetime[px][py]==0)) {
					visit[px][py]=true;
					time[px][py]=time[tx][ty]+1;
					quex.add(px); quey.add(py);
					if(px==0||py==0||px==w-1||py==h-1) {System.out.println(time[px][py]+1); return;}
				}
			}
			
			//proc(w, h);
		}
		System.out.println("IMPOSSIBLE");
	}
	
	public static void proc(int w, int h, int[][] t) {
		for(int i=0; i<w; i++) {
			for(int j=0; j<h; j++) {
				System.out.print(t[i][j]);
			}
			System.out.println();
		}
	}
	public static void fireBFS(int c, int w, int h) {
		
		while(!fx.isEmpty()&&!fy.isEmpty()) {
			int xx=fx.poll(); int yy=fy.poll();
			for(int i=0; i<4; i++) {
				int px=xx+movex[i];
				int py=yy+movey[i];
				if(px>=0&&px<=w-1&&py>=0&&py<=h-1&&visited[px][py]==false&&(field[px][py]=='.'||field[px][py]=='@')) {
					visited[px][py]=true;
					fx.add(px); fy.add(py);
					firetime[px][py]=firetime[xx][yy]+1;
				}
			}
			
		}
		//proc(w,h,firetime);
		//System.out.println();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String ss=br.readLine();
			StringTokenizer st=new StringTokenizer(ss);
			int h=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int sx=0, sy=0;
			quex.clear(); quey.clear();
			field=new char[w][h];
			visit=new boolean[w][h];
			visited=new boolean[w][h];
			firetime=new int[w][h];
			time=new int[w][h];
			int c=0;
			for(int i=0; i<w; i++) {
				String a=br.readLine();
				field[i]=a.toCharArray();
				for(int j=0; j<h; j++) {
					if(field[i][j]=='@') {
						sx=i; sy=j;
					}
					if(field[i][j]=='*') {
						fx.add(i); fy.add(j);
						visited[i][j]=true;
					}
				}
			}
			
			BFS(sx, sy, w, h, c);
			
		}
	}

}
