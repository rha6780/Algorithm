import java.util.Scanner;

public class Main {

	public static Scanner sc=new Scanner(System.in);
	public static int[][] fin=new int[101][101];
	public static int[][] fee=new int[101][101];
	public static int N=sc.nextInt();
	public static int INF=11000001;
	public static void GR() {
		for(int i=1; i<101; i++) {//거쳐가는
			for(int j=1; j<101; j++) {//출발
				for(int h=1; h<101; h++) {//도착
					if((fin[j][i]+fin[i][h])<fin[j][h]) {
						fin[j][h]=fin[j][i]+fin[i][h];
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int bus=sc.nextInt();
		for(int i=0; i<bus; i++) {
			int c1=sc.nextInt();
			int c2=sc.nextInt();
			int b=sc.nextInt();
			if(fee[c1][c2]==0)fee[c1][c2]=b;
			else if( fee[c1][c2]>b) {
				fee[c1][c2]=b;
			}
		}sc.close();
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(fee[i][j]==0) fee[i][j]=INF;
				fin[i][j]=fee[i][j];
				if(i==j) fin[i][i]=0;
			}
		}
		GR();
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(INF<=fin[i][j])fin[i][j]=0;
				System.out.print(fin[i][j]+" ");
			}
			System.out.println();
		}
	}
}