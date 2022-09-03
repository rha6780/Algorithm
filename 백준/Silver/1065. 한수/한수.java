import java.util.Scanner;
public class Main {
	
	public static void hansu(int a) {
		int c=a; int count=0; int t1,t2,t3;
		while(c>0) {
			if(c<100) count++;
			else if((c>100)&&(c<1000)) {
					t1=c%10; t2=c/10;t3=t2/10; t2%=10;
				if((t3-t2)==(t2-t1)) {
					count++;
				}
			}
			c--;
		}
		System.out.print(count);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		hansu(N);
	}
}