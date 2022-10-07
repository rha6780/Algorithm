import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int min=sc.nextInt();
		int[] num=new int [N+1];
		boolean[] m=new boolean[N+1];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
			if(num[i]<min) m[i]=true;
		}
		for(int i=0; i<N; i++) {
			if(m[i]==true) System.out.print(num[i]+" ");
		}
		
	}

}
