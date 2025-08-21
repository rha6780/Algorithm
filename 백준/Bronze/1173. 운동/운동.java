import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
	
		int result = 0;
		int heart = m;

		if (heart+T > M) {
			System.out.println(-1);
		} else {

			for(int i=0; i<N; result++) {
				
				// 안할때
				if (heart+T > M) {
					if (heart-R < m) {
						heart = m;
					} else {
						heart -= R;
					}
				} else {
					// 운동할때
					heart += T;	
					i++;
				}
				

			}
			System.out.println(result);
		}
	}

}
