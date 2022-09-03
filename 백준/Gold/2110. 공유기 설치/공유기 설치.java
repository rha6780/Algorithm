import java.util.*;
public class Main {

	public static void main(String[] args) {
		int[] home=new int[200001];
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int c=sc.nextInt();
		home=new int[N];
		int result=0;
		for(int i=0; i<N; i++) {
			home[i]=sc.nextInt();
		}
		Arrays.sort(home);
		int di=0;
		int l=1,r=home[N-1]-home[0];
		
		while(l<=r) {
			int mid=(l+r)/2;
			int start=home[0];
			int count=1;
			for(int i=0; i<N; i++) {
				di=home[i]-start;
				if(mid<=di) {
					count++;
					start=home[i];
				}
			}
			
			if(count>=c) {
				result=mid;
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		System.out.println(result);
	}

}
