import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		if(N==1||M==1) {System.out.println(1);}
		else if(N==2) {if((((M-1)/2)+1)<4)System.out.println(((M-1)/2)+1); else System.out.println(4);}
		else {
			if(M<7) {if(M>=4) {System.out.println(4);}
			else System.out.println(M);}
			
			else {
				System.out.println(M-5+3);
			}
		}
	}

}
