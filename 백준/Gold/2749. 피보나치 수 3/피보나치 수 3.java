import java.util.Scanner;
import java.math.BigInteger;
public class Main {


	public static void matmul(long[][]a, long [][]b, long[][]c) {
		for(int i=0; i<2; i++) {
			for(int j=0; j<2;j++) {
				c[i][j] = 0;
				for (int k=0;k<2; k++) {
					c[i][j] += a[i][k]*b[k][j];
				}

						c[i][j]=c[i][j]%1000000;
			}
		}
	}
	public static void matcopy(long[][]a, long[][]b) {
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++)
				b[i][j]=a[i][j];
			
		}
	}
	public static void matprint(long[][]a) {
		for(int i=0; i<2; i++) 
				System.out.println(a[i][0]+" "+a[i][1]);
		System.out.println();
	}

	public static void main(String[] args) {

		long[][]a= {{1,1},{1,0}}; 
		long[][]b=new long [2][2];
		long[][]c= {{1,0},{0,1}};
		Scanner scan=new Scanner(System.in);
		BigInteger big =new BigInteger("0");
		big=scan.nextBigInteger();
		scan.close();
		big=big.subtract(BigInteger.valueOf(1));
		
		while(big.compareTo(BigInteger.ZERO)>0) {
			if(big.mod(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(1))==0) {
				matmul(a,c,b);
				matcopy(b,c);
			}
			matmul(a,a,b);
			matcopy(b,a);
			//matprint(a);
			big=big.divide(BigInteger.valueOf(2));	
		}
	//matprint(c);
	BigInteger rest=BigInteger.valueOf(c[1][0]+c[1][1]);
	rest=rest.mod(BigInteger.valueOf(1000000));
	System.out.print(rest);
	
	}
}