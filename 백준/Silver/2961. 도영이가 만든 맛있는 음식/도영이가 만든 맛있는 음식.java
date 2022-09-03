import java.util.*;
import java.io.*;

public class Main {

	static int[][] source;
	static int N, min=Integer.MAX_VALUE;
	static void Dp(int[] t, int loc) {
		if(loc==N) {
			//요리 값 출력
			int count=0;
			int s=1, e=0;
			for(int i=0; i<N; i++) {
				if(t[i]==1) {
					s*=source[i][0];
					e+=source[i][1];
					count++;
				}
			}
			if(count!=0) {
				if(min>Math.abs(s-e)) {
					min=Math.abs(s-e);
				}
			}
			else {
				return;
			}
		}
		else {
			t[loc]=0; Dp(t,loc+1);
			t[loc]=1; Dp(t,loc+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		source = new int[N][2];
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			source[i][0] = sc.nextInt();
			source[i][1] = sc.nextInt();
		}
		
		Dp(A,0);
		System.out.println(min);
	}

}
