import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int M=sc.nextInt();
	public static int ii=0, jj=0, kk=0, hh=0, pp=0, qq=0,count=0, Max=0, midas=0;
	public static int[][] lab=new int[N][M];
	public static boolean[][] virus=new boolean[10][10];
	public static boolean[][] visit=new boolean[10][10];
	public static Queue<Integer> quer=new LinkedList<Integer>();
	public static Queue<Integer> quec=new LinkedList<Integer>();
	public static void BFS(int a, int b) {
		visit[a][b]=true;
		quer.add(a); quec.add(b);
		int coi=0;
		while(!quer.isEmpty()&&!quec.isEmpty()) {
			int rr=quer.poll(); int cc=quec.poll();
				if(rr-1>=0&&lab[rr-1][cc]==0&&visit[rr-1][cc]==false) {quer.add(rr-1);quec.add(cc);visit[rr-1][cc]=true;coi++;}
				if(cc-1>=0&&lab[rr][cc-1]==0&&visit[rr][cc-1]==false) {quer.add(rr);quec.add(cc-1);visit[rr][cc-1]=true;coi++;}
				if(rr+1<N&&lab[rr+1][cc]==0&&visit[rr+1][cc]==false) {quer.add(rr+1);quec.add(cc);visit[rr+1][cc]=true;coi++;}
				if(cc+1<M&&lab[rr][cc+1]==0&&visit[rr][cc+1]==false) {quer.add(rr);quec.add(cc+1);visit[rr][cc+1]=true;coi++;}
				
		}
			midas+=coi;
	}
	public static void lim(int x1, int y1, int x2, int y2, int x3, int y3) {
		lab[x1][y1]=1;lab[x2][y2]=1;lab[x3][y3]=1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(virus[i][j]==true)
					BFS(i, j);
				
			}}
		if(Max<=count-midas) Max=count-midas;
		lab[x1][y1]=0;lab[x2][y2]=0;lab[x3][y3]=0;
		midas=0;
		visit=new boolean[10][10];
	}
	public static void main(String[] args) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				lab[i][j]=sc.nextInt();
				if(lab[i][j]==0) { count++;}
				else if(lab[i][j]==2) {
					virus[i][j]=true;
				}
			}
		}
		count-=3;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(lab[i][j]==0) {
					ii=i; jj=j;
					for(int k=0; k<N; k++) {
						for(int h=0; h<M; h++) {
							if(!(k==i&&j==h)&&lab[k][h]==0) {
								kk=k; hh=h;
								for(int p=0; p<N; p++) {
									for(int q=0; q<M; q++) {
										if(!(p==i&&j==q)&&!(p==k&&q==h)&&lab[p][q]==0) {
											pp=p; qq=q;
											lim(ii, jj, kk, hh,pp,qq);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(Max);
	}

}
