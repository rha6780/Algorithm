import java.util.Scanner;
import java.math.*;
public class Main {
	public static BigInteger[] pp=new BigInteger[40];
	public static void pac(int a) {
		pp[0]=new BigInteger("1");
		if(a>0) {
			for(int i=1; i<=a; i++) {
				pp[i]=pp[i-1].multiply(BigInteger.valueOf(i));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		pac(31);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int a=sc.nextInt(), b=sc.nextInt();
			int mm=1;
			
			System.out.println(pp[b].divide((pp[a].multiply(pp[b-a]))));
		}

	}

}