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
		int []a=new int[123457];
		int []count=new int [123457];
		int i=0;
		Scanner scan=new Scanner(System.in);
		while(true) {
			a[i]=scan.nextInt();
			if(a[i]==0)break;
			for(int j=a[i]+1; j<=(2*a[i]); j++) {
			if(IsPrime(j)==true)
				count[i]++;
			}i++;
		}	
		for(int j=0; j<i; j++)
			System.out.println(count[j]);
	}
}