import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		int N=sc.nextInt();
		int K=sc.nextInt();
		int lasg=0, coinco=0;
		int[] coin=new int[N];
		for(int i=0; i<N; i++) {
			coin[i]=sc.nextInt();
			if(coin[i]<=K) {lasg=i;}
		}
		while(K!=0) {
			int mok=0,rest=0;
			if(lasg>0) {
			mok=K/coin[lasg];
			coinco+=mok;
			K%=coin[lasg];
			lasg--;}
			else {
				mok=K/coin[0];
				coinco+=mok;
				K=K%coin[0];
				}
		}
		System.out.println(coinco);
	}
}
