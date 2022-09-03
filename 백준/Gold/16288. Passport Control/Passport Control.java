import java.util.*;
import java.io.*;

public class Main {

	static int[] gate = new int[100];
	static void pass(int a, int k) {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] entry = new int[N];
		gate = new int[K];
		boolean result= true;
		
		for(int i=0; i<N; i++) {
			entry[i] = sc.nextInt();
			if(i==0) {gate[0]=entry[0];}
			if(i>0) {
				boolean isin = false;
				for(int h=0; h<K; h++) {
					if(gate[h]<entry[i]) {
						gate[h]=entry[i];
						isin = true;
						break;
					}
				}
				if(!isin) {
					//System.out.println(entry[i]);
					result=false;
					break;
				}
			}
		}
		
		if(result) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
