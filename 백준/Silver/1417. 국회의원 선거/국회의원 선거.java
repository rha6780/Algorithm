import java.util.*;
import java.io.*;
public class Main {

	public static int[] vote=new int[1000];
	public static int[] mind=new int[1000];
	public static void proc(int N) {
		for(int i=0; i<N; i++) {
			System.out.print(vote[i]+" ");
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		vote=new int[N];
		mind=new int[N];
		int max=0, ind=0;
		mind[0]=Integer.parseInt(br.readLine());
		for(int i=1; i<N; i++) {
			mind[i]=Integer.parseInt(br.readLine());
			if(max<mind[i]) {max=mind[i]; ind=i;}
		}
		if(ind==0) {System.out.println(0);}
		else {
			int sum=0, m=0, in=0;
			for(int i=0; i<N; i++) {
				vote[i]=mind[i]-mind[0];
				if(m<vote[i]) {m=vote[i];; in=i;}
				//System.out.println(vote[i]);
			}
			int count=0;
			while(true) {
				Arrays.sort(vote,1,N);
				//proc(N);
				if(vote[0]>vote[N-1]) {break;}
				else {
					vote[N-1]--;
					vote[0]++;
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
