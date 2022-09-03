import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++) {
			int[] exp=new int[5];
			int a=sc.nextInt();
			int b=sc.nextInt();
			a%=10;
			if(a==0) {System.out.println(10);}
			else {
			int ii=1;
			for(int j=0; j<4; j++) {
				ii*=a;
				ii%=10;
				exp[j]=ii; 
			}
			int ind=b%4;
			if(ind!=0) {
				System.out.println(exp[ind-1]);
			}
			else {
				System.out.println(exp[3]);
			}
		}
		}
	}

}
