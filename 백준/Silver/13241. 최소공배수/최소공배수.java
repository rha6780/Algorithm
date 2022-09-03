import java.util.Scanner;
public class Main {
	
	public static long gcd(long a, long b) {
		long t;
		if(a<b) {t=a; a=b;b=t;}
		while(true) {
			a=a%b;
			if(a==0) return b;
			t=a; a=b; b=t;
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long a, b,lcm;
		a=scan.nextLong();b=scan.nextLong();
		lcm=(a*b)/gcd(a,b);
		System.out.print(lcm);
	}

}
