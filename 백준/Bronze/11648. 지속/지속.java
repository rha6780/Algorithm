import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=1, count=0, y=101;
		while(y/10!=0) {m=1;if(n<10)break;
		while(n/10!=0) {
			m*=(n%10);
			n-=(n%10); n/=10;			
		}
		
		m*=n;
		y=m;count++;n=m;
		}
		System.out.print(count);
	}

}