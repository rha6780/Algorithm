import java.util.*;
public class Main {
	
	public static boolean[][] visit;
	public static char[][] round;
	public static int sheep=0;
	public static int wolf=0;
	public static int[] move1= {0,0,-1,1};
	public static int[] move2= {-1,1,0,0};
	
	public static void BFS(int a, int b) {
		Queue<Integer> quer=new LinkedList<Integer>();
		Queue<Integer> quec=new LinkedList<Integer>();
		quer.add(a); quec.add(b);
		int w=0; int s=1;
		while(!quer.isEmpty()&&!quec.isEmpty()) {
			int r=quer.poll(); int c=quec.poll();
			for(int i=0; i<4; i++) {
				int t=r+move1[i]; int p=c+move2[i];
				if(round[t][p]!='#'&&visit[t][p]==false) {
					quer.add(t); quec.add(p);
					visit[t][p]=true;
					if(round[t][p]=='v') {w++;}
					else if(round[t][p]=='o') {s++;}
				}
			}
		}
		if(w<s) {wolf-=w;}
		else {
			sheep-=s;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int R=sc.nextInt(); int C=sc.nextInt();
		round=new char[R][C];
		visit=new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s=sc.next();
			round[i]=s.toCharArray();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(round[i][j]=='o') {sheep++;}
				else if(round[i][j]=='v') {wolf++;}
				if(round[i][j]=='o') {visit[i][j]=true; BFS(i,j);}
			}
		}
		System.out.println(sheep+" "+wolf);
	}

}
