import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		HashSet<Integer> set2 = new HashSet<Integer>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] result = new int[N];
		int count = 0;

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			set2.add(Integer.parseInt(st.nextToken()));
		}

		for (int i=0; i<N; i++) {
			if (set2.remove(result[i])) {
				count ++;
			}
		}

		System.out.println(N+M-(count*2));
		
	}

}