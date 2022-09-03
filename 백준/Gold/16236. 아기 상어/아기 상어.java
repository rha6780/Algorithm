import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
	int x, y, t;
	public Node(int x, int y, int t) {
		this.x=x; this.y=y; this.t=t;
	}
}
public class Main {

	public static ArrayList<Node> arr=new ArrayList<Node>();
	public static int N=0, count=0, time=0, eatcount=0, size=2;
	public static int x=0, y=0;
	public static int[][] field;
	public static boolean[][] visited;
	public static int[] movex= {-1,0,0,1};
	public static int[] movey= {0,-1,1,0};
	
	public static void proc() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void eat(int x1, int y1, int t) {
		int min=999;
		for(int i=0; i<arr.size(); i++) {
			if(min>arr.get(i).x) {min=arr.get(i).x;}
		}
		time+=t;		
		field[x1][y1]=0;
		eatcount++;
		if(eatcount==size) {size++; eatcount=0;}
		x=x1; y=y1;
	}
	public static boolean BFS(int ax, int ay) {
		int fishcount=0, smalltime=0;
		int[][] tt=new int[N][N];
		Queue<Integer> quex=new LinkedList<Integer>();
		Queue<Integer> quey=new LinkedList<Integer>();
		visited[ax][ay]=true;
		quex.add(ax); quey.add(ay);
		while(!quex.isEmpty()&&!quey.isEmpty()) {
			int tx=quex.poll(); int ty=quey.poll();
			for(int i=0; i<4; i++) {
				int px=tx+movex[i]; int py=ty+movey[i];
				if(px>=0&&py>=0&&px<N&&py<N&&visited[px][py]==false) {
					if(field[px][py]<=size) {
					quex.add(px); quey.add(py);
					visited[px][py]=true;
					tt[px][py]=tt[tx][ty]+1;
					if(field[px][py]>0&&field[px][py]<size) {
						
						if(fishcount==0) {fishcount=1; smalltime=tt[px][py];}
						if(smalltime==tt[px][py]) {
							arr.add(new Node(px, py, tt[px][py]));
						}

					}
				}	
				}
			}
		}
		if(fishcount>0) {return true;}
		else {return false;}
	}
	public static void search() {
		if(count==0) {return;}
		else if(count>0) {
			boolean iscon=true;
			while(iscon) {
				visited=new boolean[N][N];
				arr.clear();
				arr=new ArrayList<Node>();
				field[x][y]=0;
				if(BFS(x, y)) iscon=true;
				else break;
				Collections.sort(arr, new Comparator<Node>() {
					@Override
					public int compare(Node n1, Node n2) {
						if(n1.x<n2.x) {
							return -1;
						}
						else if(n1.x==n2.x) {
							if(n1.y<n2.y) {return -1;}
							else {return 1;}
						}
						else {
							return 1;
						}
					}
					
				});

				eat(arr.get(0).x, arr.get(0).y, arr.get(0).t);

			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String r=br.readLine();
		StringTokenizer st=new StringTokenizer(r);
		N=Integer.parseInt(st.nextToken());
		field=new int[N][N]; visited=new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String s=br.readLine();
			st=new StringTokenizer(s);
			for(int j=0; j<N; j++) {
				field[i][j]=Integer.parseInt(st.nextToken());
				if(field[i][j]!=0&&field[i][j]<9) {count++;}
				if(field[i][j]==9) {x=i; y=j; }
			}
		}
		search();
		System.out.println(time);
	}

}
