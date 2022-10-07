import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] num;
	public static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int[] result = new int[N+1];
		long min = num[0]+num[1];
		int ss=0;
		int sub = 2;
		for(int i=0; i<N; i++) {
			if(i+1<N) {
				long n1 = num[i]+num[i+1];
				//System.out.println(min+" "+n1+" "+Math.log(min*2)+" "+Math.log(n1*sub));
				if(Math.log(min*2)>Math.log(n1*sub)) {
					min=n1;
					sub=2;
					ss=i;
				}
				if(i+2<N) {
					long n2 = n1;
					int count = 2;
					for(int j=i+2; j<N; j++) {
						n2+=num[j]; count++;
						long nn = n2;
						if(Math.log(min*count)>Math.log(nn*sub)) {
							min=nn;
							sub=count;
							ss=i;
						}
						else {
							break;
						}
					}
					long n3 = num[i+1]+num[i+2];
					if(Math.log(min*2)>Math.log(n3*sub)) {
						min=n3;
						sub=2;
						ss=i+1;
					}
				}
			}
			//System.out.println(i+" "+ss+" "+min);
		}
		System.out.println(ss);
		
	}

}
