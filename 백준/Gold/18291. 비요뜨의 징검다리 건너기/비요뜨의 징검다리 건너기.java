import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static long power(long N, long Base) {
	      long base = 2;
	      long pp=1;
	      while (N>0) {
	    	  if(N%2==1)
	            pp = (pp*base) % Base;
	            base = (base*base) % Base;
	            N = N/2;
	         }
	         System.out.println(pp);
	         return pp;
	}
	
	public static BigInteger big=new BigInteger("0");
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		
		for(int i=0; i<a; i++) {
			int b=sc.nextInt();
			if(b==1||b==2) {System.out.println(1);}
			else { 
			power(b-2,1000000007);
			
			}
		}
		sc.close();
	}
}
