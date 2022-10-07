import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int T=sc.nextInt();
	public static long[] tr;

	public static void main(String[] args) {
		int a=0; 
		for(int i=0; i<T; i++) {
			a=sc.nextInt();
			tr=new long[a+1]; 
			tr[0]=1;
			for(int j=1; j<=a; j++) {
				if(j<4) tr[j]=1;
				else if(j>=4&&j<6) tr[j]=2;
				else if(j==6) tr[j]=3;
				else {
					tr[j]=tr[j-1]+tr[j-5];
				}
			}
			System.out.println(tr[a]);
		}
		

	}

}
