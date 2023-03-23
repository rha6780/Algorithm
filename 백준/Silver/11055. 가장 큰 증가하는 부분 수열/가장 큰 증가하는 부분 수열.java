import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int[] AAA=new int[N];
	public static int[] sum=new int[N];
	public static void main(String[] args) {
		for(int i=0; i<N; i++) {
			AAA[i]=sc.nextInt();
		}
		sum[0]=AAA[0];
		for(int i=1; i<N; i++) {
			int Max=0;
			for(int j=0; j<i; j++) {
			if(AAA[j]<AAA[i]) {if(Max<sum[j])Max=sum[j];}
			}
			sum[i]+=Max+AAA[i];
		}
		int MM=0;
		for(int i=0; i<N; i++) {
			if(MM<=sum[i]) {
				MM=sum[i];
			}
		}
		System.out.println(MM);
	}

}
