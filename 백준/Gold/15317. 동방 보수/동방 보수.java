import java.util.*;
import java.io.*;
public class Main {
	public static long[] room=new long[100000]; //보수비용
	public static long[] money=new long[10000]; //운영비용
	public static int result=0;

	public static boolean donate(int n, long x, int m) {
		long jj=0;
		for(int i=0; i<n; i++) {
			if(room[i]>money[m-n+i]) {
				jj+=room[i]-money[m-n+i];
				//System.out.println(n+" "+room[i]+" "+money[m-n+i]);
			}
		}
		if(jj<=x) {return true;}
		else return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		long X=Integer.parseInt(st.nextToken());
		room=new long[N]; money=new long[M];
		int flag=Math.min(M, N);
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {room[i]=Integer.parseInt(st.nextToken());}
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {money[i]=Integer.parseInt(st.nextToken());}
		Arrays.sort(room);
		Arrays.sort(money);

		int r=flag, l=0;
		while(r-l>10) {
			int mid=(l+r)/2;
			if(donate(mid, X, M)) {l=mid;} //후원 가능한 수준
			else {r=mid-1;} //후원 불가
		}
		for(int i=r; i>=l; i--) {if(donate(i, X, M)) {System.out.println(i); return;}}
		System.out.println(0);
	}

}
