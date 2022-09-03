import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] waiting=new int[N];
		int[] minimun=new int[N];
		int min=1200,Sum=0;
		for(int i=0; i<N; i++) {
			waiting[i]=sc.nextInt();
		}
		Arrays.sort(waiting);
		for(int i=0; i<N; i++) {
			if(i==0)
			minimun[i]=waiting[i];
			else
			minimun[i]+=waiting[i]+minimun[i-1];
			
			Sum+=minimun[i];
		}
		System.out.println(Sum);
	}
}