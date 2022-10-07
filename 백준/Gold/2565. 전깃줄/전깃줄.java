import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] a=new int[N][N];
		int[] c=new int[501];
		for(int i=0; i<N; i++){
			a[i][0]=sc.nextInt(); a[i][1]=sc.nextInt();
		}
		Arrays.sort(a, new Comparator<int[]>(){
			@Override
			public int compare(final int[] a1, final int[] a2){
				final Integer t1=a1[0];
				final Integer t2=a2[0];
				return t1.compareTo(t2);
			}
			
		});
		
		for(int i=0; i<N; i++){
			for(int j=0; j<i; j++){
				if(a[i][0]>a[j][0]&&a[i][1]>a[j][1]){//i번째 줄이 있을때 남은 선의 수
					if(c[i]<c[j]){
						c[i]=c[j];
					}
				}
				
			}
			c[i]++;
		}
		int Max=0;
		for(int i=0; i<N; i++){
			
			if(Max<c[i]){
				Max=c[i];
			}
		}
		System.out.println(N-Max);
	}

}
