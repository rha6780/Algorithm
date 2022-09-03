import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int a=sc.nextInt();
			int count=0;
			while(a>0) {
				if(a%2==1) {System.out.print(count+" ");}
				a/=2;
				count++;
			}
		}

	}

}
