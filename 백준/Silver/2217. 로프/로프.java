import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 int N=sc.nextInt();
	 int[] rope=new int[N];
	 int a=0;
	 int Max=0;
	 for(int i=0; i<N; i++) {
		 rope[i]=sc.nextInt();
	 } 
	 Arrays.sort(rope);
	 for(int i=0; i<N; i++) {
		 a=rope[i]*(N-i);
		 if(Max<=a)
			 Max=a;}
	 System.out.println(Max);
	 
	}

}
