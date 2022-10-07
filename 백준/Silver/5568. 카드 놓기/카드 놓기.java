import java.util.*;
import java.io.*;

public class Main {

	static int N, K;
	static int[] card;
	static HashSet<String> set;
	
	static void perm(int[] t, int loc) {
		if(loc == K) {
			String s = "";
			for(int i=0; i<K; i++) {
				s = s +card[t[i]];
			}
			set.add(s);
		}
		else {
			for(int i =0; i<N;i++) {
				int p = t[loc]; t[loc]=t[i]; t[i]=p;
				perm(t, loc+1);
				p = t[loc]; t[loc]=t[i]; t[i]=p;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		
		card = new int[N];
		int[] map = new int[N];
		for(int i=0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			map[i] = i;
		}
		
		set = new HashSet<String>();
		perm(map, 0);
		System.out.println(set.size());
			

	}

}
