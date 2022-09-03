import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt();
		int[] rest=new int[N];
		int count=0;
		for(int i=1; i<=N; i++) {
			if(N%i==0) {rest[count]=i; count++;}
		}
		System.out.println(rest[K-1]);
	}

}
