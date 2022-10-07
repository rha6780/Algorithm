import java.util.Scanner;
import java.math.BigInteger;
public class Main {
	public static void main(String[] args) {
		int result=0;
		Scanner sc = new Scanner(System.in);
        BigInteger big=new BigInteger("10");
		big=sc.nextBigInteger();
		if(big.compareTo(BigInteger.valueOf(1))==0) {
			result=2;
		}
		else {
			result=1;
		}
		System.out.println(result);
	}
}