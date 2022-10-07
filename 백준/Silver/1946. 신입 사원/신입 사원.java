import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(sc.readLine());
		for(int t=0; t<T; t++) {
			int N =Integer.parseInt(sc.readLine());
			int[][] sawon = new int[N][2];

			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(sc.readLine());
				sawon[i][0] = Integer.parseInt(st.nextToken());
				sawon[i][1] = Integer.parseInt(st.nextToken());
			}
			int count = 1;
			Arrays.sort(sawon, new Comparator<int[]>() {
				public int compare(int a1[],  int a2[]) {
					return Integer.compare(a1[0], a2[0]);
				}
			});
			
			int score = sawon[0][1];
			for (int i=1; i<N; i++) {
				if(score > sawon[i][1]) {
					score = sawon[i][1];
					count++;
				}
			}
			System.out.println(count);
		}

	}

}
