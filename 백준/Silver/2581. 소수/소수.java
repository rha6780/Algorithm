import java.util.Scanner;
public class Main {

	public static boolean IsPrime(int n) {   // 소수 구하기^ㅡ^ ;
		if(n==1) {
			return false;
		}
		int b = (int)Math.sqrt((double)n); //루트 구하기   
		for(int i=2;i<=b;i++){
			if(n%i == 0) return false;
		}
		return true;		
		}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N, M,sum=0, k=0,min=0;
		N=scan.nextInt();M=scan.nextInt();
		for(int i=N; i<=M; i++) {
			if(IsPrime(i)==true) {
			sum+=i;
			if(k<1)
				min=i;k++;
			}
		}if(sum==0) {
				System.out.print("-1");
			}
		else {
			System.out.println(sum);
			System.out.print(min);
		}
	}

}