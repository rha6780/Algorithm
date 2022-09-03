import java.util.Scanner;

public class Main {

	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	static void mlumat(int[][] A, int [][]b,int [][]c) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				c[i][j]=0;
				for(int k=0; k<N; k++) {
					c[i][j]+=A[i][k]*b[k][j];
					if(c[i][j]>=1000) c[i][j]%=1000;
				}
			}
		}
	}
	static void show(int [][]g) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(g[i][j]+" ");
			System.out.println();
		}
	}
	static void copymat(int [][]h, int [][]j) {

		for(int i=0; i<N; i++) {
			for(int k=0; k<N;k++)
				h[i][k]=j[i][k];
		}
	}

	public static void main(String[] args) {
	
		long n=sc.nextLong();
		int[][] A= new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
			A[i][j]=sc.nextInt();
		int[][] C=new int[N][N];
		int[][] S=new int[N][N];
        sc.close();
		for(int i=0; i<N; i++) 
				 S[i][i]=1;

		int[][] D=new int [N][N];
		copymat(D,A);

		while(n>0) {
			if(n%2==1) {
				mlumat(D,S,C);
				copymat(S,C);
			}
			mlumat(D,D,C);
			copymat(D,C);
			n/=2;
		}
		show(S);
	}
}