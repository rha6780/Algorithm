import java.util.*;
import java.io.*;

public class Main {

	static boolean ishappy = false;
	static int N;
	static boolean[] num= new boolean[1000000001];
	static void DP(int a) {
		if(a==1) {
			ishappy = true;
			return;
		}
		else if(num[a]) {
			return;
		}
		num[a]=true;
		String s = a+"";
		int nextint = 0;
		for(int i=0; i<s.length(); i++) {
			int b=(int)(s.charAt(i)-'0');
			nextint += b*b;
		}
		//System.out.println(nextint);
		DP(nextint);
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		if (N==1) {ishappy=true;}
		else {DP(N);}
		
		if (ishappy) {System.out.println("HAPPY");}
		else {System.out.println("UNHAPPY");}
	}

}
