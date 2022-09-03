import java.util.*;
import java.io.*;
public class Main {

	public static int[] crane=new int[100];
	public static int[] box=new int[100];
	public static int[] count=new int[100000];

	public static int N=0, M=0, result=0;
	public static void batch() {
		int ind=0;
		for(int i=0; i<M; ) {
			if(crane[ind]>=box[i]) {count[ind]++;i++;}
			else {
				ind++;
			}
		}

		while(true) {
		boolean iscount=false;
		for(int i=N-1; i>=0; i--) {
			if(count[i]!=0) {iscount=true; count[i]--;}
			else {
				for(int j=i-1; j>=0; j--) {
					if(count[j]!=0) {count[j]--; iscount=true; break;}
				}
			}
		}
		if(iscount==false) {break;}
		result++;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		crane=new int[N];
		count=new int[N];
		String rr=br.readLine();
		StringTokenizer st=new StringTokenizer(rr);
		for(int i=0; i<N; i++) {crane[i]=Integer.parseInt(st.nextToken());}
		Arrays.sort(crane);
		M=Integer.parseInt(br.readLine());
		box=new int[M];
		String rss=br.readLine();
		st=new StringTokenizer(rss);
		boolean isp=true;
		for(int i=0; i<M; i++) {
			box[i]=Integer.parseInt(st.nextToken());
			if(crane[N-1]<box[i]) {isp=false;}
		}
		Arrays.sort(box);

		if(!isp) {System.out.println(-1); return;}
		else {
			batch();	
			System.out.println((result));
		}

	}

}
