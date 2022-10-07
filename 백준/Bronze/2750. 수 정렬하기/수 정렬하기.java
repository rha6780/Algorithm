import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();int[] ar=new int[N];
		for(int i=0; i<N; i++) {
			ar[i]=sc.nextInt();
		}
		int min=1001, tmp=0, l=0;
		for(int i=0; i<N; i++) {min=1001;
			for(int j=i; j<N; j++) {
				if(ar[j]<min) {min=ar[j]; l=j;}
			} 
			tmp=ar[i];
			ar[i]=min;
			ar[l]=tmp;
		}
		for(int i=0; i<N; i++) {
			System.out.println(ar[i]);
		}

	}
}