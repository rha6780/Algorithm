import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int T=sc.nextInt();
	public static int[][] hc=new int [T][3];
	public static int[][] hce=new int [T][3];
	
	public static int nexti(int a, int b) {
		if(a<b) return a;
		else return b;
		
	}
	public static void dic(int a) {
		int min=Integer.MAX_VALUE;
		
		for(int i=0; i<a; i++) {
			for(int j=0; j<3; j++) {
				if(i<1) {
					hce[i][j]=hc[i][j];
				}
				else {
				if(j==0)
					hce[i][j]+=(nexti(hce[i-1][1], hce[i-1][2])+hc[i][j]);
				else if(j==1)
					hce[i][j]+=nexti(hce[i-1][0], hce[i-1][2])+hc[i][j];
				else 
					hce[i][j]+=nexti(hce[i-1][0], hce[i-1][1])+hc[i][j];
			}
		}
	}
	}
	
	public static void main(String[] args) {
		int min=Integer.MAX_VALUE;
		for(int i=0; i<T; i++) {
			for(int j=0;j<3; j++)
			hc[i][j]=sc.nextInt();
		}
		dic(T);
		for(int i=0; i<3; i++) {
			if(hce[T-1][i]<min) min=hce[T-1][i];
		}
		System.out.print(min);
	}
}