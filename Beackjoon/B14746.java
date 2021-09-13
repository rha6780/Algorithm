import java.util.*;
import java.io.*;

public class B14746 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		int c1=sc.nextInt(); int c2=sc.nextInt();
		
		int[] P = new int[N];
		int[] Q = new int[M];
		
		for(int i=0; i<N; i++) {
			P[i]=sc.nextInt();
		}
		for(int j=0; j<M; j++) {
			Q[j]=sc.nextInt();
		}
		
		sc.close();
		Arrays.sort(P);
		Arrays.sort(Q);
		
		int min=999999999;
		int count=0;
		int j=0; int i=0;
		while(i<N&&j<M) {
			if(min > Math.abs(P[i]-Q[j])) {
				min = Math.abs(P[i]-Q[j]);
				count=1;
				//System.out.println(min);
			}
			else if(min == Math.abs(P[i]-Q[j])) {
				count++;
				//System.out.println(min);
			}
			if(P[i]<Q[j]){
				i++;
				//System.out.println(i);
			}
			else {
				j++;
				//System.out.println(j);
			}
		}
			
		System.out.println(min+Math.abs(c1-c2)+" "+count);
	}

}
