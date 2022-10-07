import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long[] cost=new long[N];
		for(int i=0; i<N; i++) {
			cost[i]=sc.nextInt();
		}
		int M=sc.nextInt();
		
		Arrays.sort(cost);
		long left=1, right=cost[N-1];
		long result=0, hap=0;
		while(left<=right) {
			long mid=(left+right)/2;
			hap=0;
			for(int i=0; i<N; i++) {
				if(mid>=cost[i]) {hap+=cost[i];}
				else {hap+=mid;}
			}
			if(hap>M) {right=mid-1;}
			else {
				if(result<mid) {result=mid;}
				left=mid+1;
			}
		}
		System.out.println(result);

	}

}
