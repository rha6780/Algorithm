import java.util.Scanner;
public class Main {
	public static boolean IsPrime(int n) {  
		if(n==1) {
			return false;
		}
		int b = (int)Math.sqrt((double)n);  
		for(int i=2;i<=b;i++){
			if(n%i == 0) return false;
		}
		return true;		
		}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N, M;
		N=scan.nextInt();M=scan.nextInt();
		for(int i=N; i<=M; i++) {
			if(IsPrime(i)==true) {
				System.out.println(i);
			}
		}
	}
}