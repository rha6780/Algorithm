import java.util.*;
import java.io.*;

public class Main {

	static int gcd(int a, int b) {
		if(b==0) {return a;}
		else {
			return gcd(b, a%b);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = new int[6];
		int[] B = new int[6];
		
		for(int i=0; i<6; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<6; i++) {
			B[i] = sc.nextInt();
		}
		
		int count=0;
		for(int i=0; i<6; i++) {
			for(int j=0; j<6;j++) {
				if(A[i]>B[j]) {
					count++;
				}
			}
		}
		//System.out.println(count+" "+36);
		int gg=gcd(count, 36);
		System.out.println(count/gg+"/"+36/gg);
	}

}
