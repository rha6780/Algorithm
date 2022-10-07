import java.util.Scanner;
public class Main {

	public static int gcd(int a, int b) {
		int t;
		if(a<b) {t=a; a=b; b=t;}
		while(true) {
		a=a%b;
		if(a==0) return b;
		t=a; a=b; b=t;}
	}
	public static void main(String[] args) {
		int a,b,lcm,g;
		Scanner scan=new Scanner(System.in);
		a=scan.nextInt();b=scan.nextInt();scan.close();
		g=gcd(a,b);
		lcm=(a*b)/g;
		System.out.println(g);
		System.out.println(lcm);
	}
}