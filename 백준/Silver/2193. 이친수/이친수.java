import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static long[] binary=new long[91];
	public static long DP(int n) {
		binary[1]=1;binary[2]=1;binary[3]=2;
		if(n==1) {return 1; }
		else if(n==2) {return 1;}
		else if(n==3) {return 2;}
		else {
			for(int i=4; i<=n; i++) {
			binary[i]=binary[i-2]+binary[i-1];}
		}
		return binary[n];
	}
	public static void main(String[] args) {
		
		System.out.println(DP(N));

	}

}