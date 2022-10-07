import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++) {
			int s=sc.nextInt();
			int n=sc.nextInt();
			int sum=s;
			for(int j=0; j<n; j++) {
				int a=sc.nextInt(); int b=sc.nextInt();
				sum+=(a*b);
			}
			System.out.println(sum);
		}

	}

}
