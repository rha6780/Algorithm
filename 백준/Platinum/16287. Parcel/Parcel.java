import java.util.*;
import java.io.*;
public class Main {

	public static Set<Integer> set=new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int W=Integer.parseInt(st.nextToken());int N=Integer.parseInt(st.nextToken());
		int[] waight=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			waight[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<N; j++){
				if(W>(waight[i]+waight[j])&&set.contains(W-waight[i]-waight[j])) {
					System.out.println("YES"); return;
				}
			}
			for(int j=i-1; j>=0; j--) {
				set.add(waight[i]+waight[j]);
			}
		}
		System.out.println("NO");

	}

}
