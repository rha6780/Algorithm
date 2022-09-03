import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int T=sc.nextInt();
	public static boolean[] prz=new boolean[500];
	public static void main(String[] args) {
		for(int y=0; y<T; y++) {
			int N=sc.nextInt();
			prz=new boolean[N+1];
			prz[1]=true;
		for(int i=2; i<N+1; i++) {
			double dd=Math.sqrt(i);
			if(dd%1==0) {prz[i]=true;}
		}
		
		int count=0;
		for(int i=1; i<N+1; i++) {
			if(prz[i]==true) count++;
		}
		System.out.println(count);
	}
	}
}