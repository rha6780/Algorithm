import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		long[] tree=new long[N];
		for(int i=0; i<N; i++) {
			tree[i]=sc.nextInt();
		}
		Arrays.sort(tree);
		
		long need=0;
		long result=0;
		long l=0, r=tree[N-1];
		while(l<=r) {
			long mid=(l+r)/2;
			need=0;
			for(int i=0; i<N; i++) {
				if(tree[i]>=mid)need+=tree[i]-mid;
			}
			if(need<M) {
				r=mid-1;
			}
			else {
				l=mid+1;
				if(result<mid) {result=mid;}
			}
	
		}
		System.out.println(result);
	}

}
