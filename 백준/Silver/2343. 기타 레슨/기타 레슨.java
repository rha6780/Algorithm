import java.util.*;
import java.io.*;

public class Main {

	static int[] lecture;
	static long result = Integer.MAX_VALUE;
	public static void binarySearch(long left, long right, int N, int M) {
		if(left<=right) {
		long mid = (int)((left+right)/2);
		int tmp = 0;
		int count = 1;
		int maxsize=0;
		for(int i=0; i<N; i++) {
			if(mid >= tmp+lecture[i]) {
				tmp+=lecture[i];
			}
			else {
				count++;
				tmp = lecture[i];
			}

			if(maxsize<tmp) {
				maxsize=tmp;
			}
		}
		if(count>M) {
			binarySearch(mid+1, right, N, M);
		}
		else if(count<=M) {
			if(result>maxsize) {result = maxsize;}
			binarySearch(left, mid-1, N, M);
		}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int M = sc.nextInt();
		lecture =  new int[N];
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			lecture[i] = sc.nextInt();
			sum+= lecture[i];
		}
		binarySearch(0, sum, N, M);
		System.out.println(result);

	}

}
