import java.util.Scanner;

public class Main {

	static int[] dol;
	static int N, K;
	
	public static double std(int t, int f) {
		
		double sum=0, cnt=0, mi=0;
		for(int i=t; i<=f; i++) {
			sum+=dol[i];
			cnt++;
		}
		mi=(sum/cnt);
		sum=0;
		for(int i=t; i<=f; i++) {
			sum+=(mi-dol[i])*(mi-dol[i]);
		}
		sum/=cnt;
		sum=Math.abs(Math.sqrt(sum));
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		double min=(double)Integer.MAX_VALUE;
		dol=new int [N];
		for(int j=0; j<N; j++) {
			dol[j]=sc.nextInt();
		} sc.close();
		
		for(int h=K-1; h<N; h++) {
			for(int j=0; j<N-h ;j++) {
			if(min>std(j,j+h))
				min=std(j,j+h);
			}
		}
		System.out.print(min);
		
	}

}