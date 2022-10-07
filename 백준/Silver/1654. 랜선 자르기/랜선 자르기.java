import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt(), N=sc.nextInt();
		long [] lan=new long[K];
		for(int i=0; i<K; i++) {
			lan[i]=sc.nextInt();
		}
		Arrays.sort(lan);
		long result=0;
		long left=1, right=lan[K-1];
		while(left<=right) {
			long mid=(left+right)/2;
			long count=0;
			for(int i=0; i<K; i++) {
				count+=lan[i]/mid;
			}
			if(count<N) {right=mid-1;}
			else {
				if(result<mid) {result=mid;}
				left=mid+1;
			}
		}
		System.out.println(result);
	}

}
