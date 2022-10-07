import java.util.*;
class floor{
	char[][] field; int F; boolean[][] visit; int[][] time;
	public floor(char[][]fiel, int F, int n, int m, boolean[][] vis) {
		this.F=F; field=new char[n][m]; visit=new boolean[n][m]; time=new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				this.field[i][j]=fiel[i][j];
				this.visit[i][j]=vis[i][j];
				this.time[i][j]=0;
			}
		}
	}
}
public class Main {
	
	public static int[] moveu= {0,0,0,0,-1,1};
	public static int[] mover= {0,0,-1,1,0,0};
	public static int[] movec= {-1,1,0,0,0,0};
	
	public static void BFS(int l, int r, int c, int L, int R, int C) {
		Queue<Integer> quel=new LinkedList<Integer>();
		Queue<Integer> quer=new LinkedList<Integer>();
		Queue<Integer> quec=new LinkedList<Integer>();
		quel.add(l);quer.add(r);quec.add(c);
		com.get(l).visit[r][c]=true;
		boolean find=false;
		while(!quel.isEmpty()&&!quer.isEmpty()&&!quec.isEmpty()) {
			int fl=quel.poll(); int fr=quer.poll(); int fc=quec.poll();
			for(int i=0; i<6; i++) {
				int lf=fl+moveu[i]; int rf=fr+mover[i]; int cf=fc+movec[i];
				if(lf>=0&&lf<L&&rf>=0&&rf<R&&cf>=0&&cf<C&&com.get(lf).field[rf][cf]!='#'&&com.get(lf).visit[rf][cf]==false) {
					quel.add(lf); quer.add(rf); quec.add(cf);
					com.get(lf).visit[rf][cf]=true;
					com.get(lf).time[rf][cf]=com.get(fl).time[fr][fc]+1;
					if(com.get(lf).field[rf][cf]=='E') {System.out.println("Escaped in "+com.get(lf).time[rf][cf]+" minute(s).");return;}
				}
			}
		}
		
		System.out.println("Trapped!");
		quel.clear(); quer.clear(); quec.clear();
		
	}

	public static ArrayList<floor> com;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
		com=new ArrayList<floor>();
		int L=sc.nextInt(); //층수
		int R=sc.nextInt(); //행
		int C=sc.nextInt(); //열
		int sl=0, sr=0, cs=0;
		if(L==0) {break;}
		String s="";
		for(int i=0; i<L; i++) {
			char[][] f=new char[R][C];
			boolean[][] vis=new boolean[R][C];
			
			for(int j=0; j<R; j++) {
				s=sc.next();
				f[j]=s.toCharArray();
				
				for(int k=0; k<s.length(); k++) {
					if(f[j][k]=='S') {
						sl=i; sr=j; cs=k;
						
					}
				}
			}
			
			com.add(new floor(f,i,R,C,vis));
			
		}
		
		BFS(sl,sr,cs,L,R,C);
		com.clear();
	
		}

	}

}
