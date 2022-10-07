import java.util.Scanner;
public class Main {
	public static int gcd(int a, int b) {
		int t;
		if(a<b) {t=a; a=b;b=t;}
		while(true) {
			a=a%b;
			if(a==0) return b;
			t=a; a=b; b=t;
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T, i, t=0,subt=0;
		T=scan.nextInt();
		int []ring=new int [T];
		for(i=0; i<T; i++) {
			ring[i]=scan.nextInt();
		}scan.close();
		for(i=1; i<T; i++) {
		t=ring[0]/gcd(ring[0],ring[i]);
		subt=ring[i]/gcd(ring[0],ring[i]);
		System.out.println(t+"/"+subt);
		}
	}
}