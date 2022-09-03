import java.util.Scanner;
import java.math.BigInteger;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class Main {

	   public static BigInteger gcd(BigInteger a, BigInteger b) {
	      BigInteger t;
	      
	      while ( b.equals(BigInteger.ZERO) != true) {
	         t = a.mod(b);
	         if (t.equals(BigInteger.ZERO)==true) return b;
	         a=b; b=t;
	      }
	      return a;
	   }
	   
	   public static void main(String[] args) throws Exception {

	      Scanner sc = new Scanner(System.in);
	      BigInteger A = sc.nextBigInteger();
	      BigInteger B = sc.nextBigInteger();
	      sc.close();
	      BigInteger t=new BigInteger("0");
	      if (A.compareTo(B) <0) {
	         t= A; A=B; B=t;
	      	}
	      BigInteger n = gcd(A, B);

	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   
	      while (n.equals(BigInteger.ZERO) != true) {
	         bw.write("1");
	         n=n.subtract(BigInteger.ONE);
	      }
	      
	      bw.flush();
	      bw.newLine();
	      bw.close();

	   }
}