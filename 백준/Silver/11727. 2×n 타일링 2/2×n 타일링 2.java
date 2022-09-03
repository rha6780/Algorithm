import java.util.*;
public class Main {

	public static int[] D;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		D=new int[N+1];
		for(int i=1; i<=N; i++) {
			if(i==1) {D[i]=1;}
			else if(i==2) {D[i]=3;}
			else if(i==3) {D[i]=5;}
			else {
				D[i]=((D[i-2]*2)+D[i-1])%10007;
			}
		}
		System.out.println(D[N]);
	}
}