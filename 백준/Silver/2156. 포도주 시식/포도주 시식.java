import java.util.*;
public class Main {

	public static int N;
	public static int[] wine;
	public static int[][] wg;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		wine=new int[N+1];
		wg=new int[N+2][3];
		for(int i=1; i<=N; i++){
			wine[i]=sc.nextInt();
		}
		if(N==1){System.out.println(wine[1]);}
		else{
		wg[1][0]=wine[1]; wg[2][0]=wine[1]; //i 잔 마실때 첫잔
		wg[2][1]=wine[2]; wg[2][2]=wine[1]+wine[2]; //연속 2잔 마실때
		
		for(int i=3; i<=N; i++){
			wg[i][0]=Math.max(Math.max(wg[i-1][2], wg[i-1][1]),wg[i-1][0]);
			wg[i][1]=wg[i-1][0]+wine[i];
			wg[i][2]=wg[i-1][1]+wine[i];
		}
		int max=Math.max(Math.max(wg[N][0], wg[N][1]), wg[N][2]);
		System.out.println(max);
		}
	}

}
