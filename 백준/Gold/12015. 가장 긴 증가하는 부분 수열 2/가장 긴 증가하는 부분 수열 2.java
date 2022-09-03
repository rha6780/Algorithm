import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int cnt=1;
		int[] LIS = new int[N+1];
		LIS[0]=num[0];
		for(int i=0; i<N; i++) {
			if(LIS[cnt-1]<num[i]) {
				LIS[cnt] = num[i];
				cnt++;
			}
			else {
				int l = 0;
				int r = cnt;
				while(l<=r) {
					int mid = (l+r)/2;
					if(LIS[mid]<num[i]) {
						l = mid+1;
					}
					else {
						r = mid-1;
					}
				}
				
				LIS[l] = num[i];
			}
		}
		
		
		System.out.println(cnt);
		
	}

}
