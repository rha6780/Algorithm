import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] num=new int[N*2];
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		for(int i=0; i<2*N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int min=Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			if(num[i]+num[2*N-i-1]<min) {
				min=num[i]+num[2*N-1-i];
			}
		}
		System.out.println(min);
	}

}
