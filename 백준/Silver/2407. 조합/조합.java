import java.util.*;
import java.math.*;

public class Main {

	
	static BigInteger[][] comb=new BigInteger[102][102];
	public static void combination(int n, int m) {
		comb[0][0]=BigInteger.ONE;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) {comb[i][j]=BigInteger.ONE;}
				else {
					if(i-1<j) {comb[i][j]=comb[i-1][j-1];}
					else comb[i][j]=comb[i-1][j-1].add(comb[i-1][j]);
				}
				if(i==n&&j==m) {System.out.println(comb[i][j]);}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		combination(N,M);
		
	}

}
