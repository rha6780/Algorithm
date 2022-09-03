import java.util.Scanner;
public class Main{

		public static void multm(int[][]a, int[][]b, int[][]c, int t) {
			for(int i=0; i<t; i++) {c[i][0]=0;
				for(int j=0; j<t; j++) 	{	
					c[i][0]+=a[i][j]*b[j][0];
					if(c[i][0]>31991) c[i][0]%=31991;
				}
			}
		}//multiple matrix;
		public static void multm1(int[][]a, int[][]b, int[][]c, int t,int d) {
			for(int i=0; i<t; i++) {
				for(int j=0; j<t; j++) {
				c[i][j]=0;
				for(int k=0; k<d; k++) {
					c[i][j]+=a[i][k]*b[k][j];
					if(c[i][j]>31991) c[i][j]%=31991;
				}
				}
			}
		}//제곱
		public static void cpym(int[][]a, int[][]b, int d) {
			for(int i=0; i<d; i++) {
				for(int j=0; j<d; j++)
				b[i][j]=a[i][j];
			}
		}
		public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int D=sc.nextInt();
		int T=sc.nextInt();
		int[][] im=new int[D][D];
		
		int [][] dum=new int[D][D];
		int[][] s=new int[D][D];
		sc.close();
		
		for(int i=0; i<D ;i++) {
			for(int j=0; j<D; j++) {
			if(i==0) im[0][j]=1;
			else if(i==1) {if(j==0)im[1][j]=1; else im[1][j]=0;}
			else { if(i-1==j)im[i][j]=1; else im[i][j]=0; }
			}
		}//i matrix;

		for(int i=0; i<D; i++) s[i][i]=1;
		int hh=T;
		while(hh>0) {
			if(hh%2==1) {multm(im,s,dum,D); cpym(dum,s,D);}
			multm1(im,im,dum,D,D); cpym(dum,im,D);
			hh=hh/2;
			if(s[0][0]>31991) s[0][0]%=31991;
		}
		System.out.print(s[0][0]);
	}
}