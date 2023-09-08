import java.io.*;
import java.util.*;


class Problem implements Comparable<Problem>{
	int level;
	int time;

	public Problem(int level, int time) {
		this.level = level;
		this.time = time;
	}

	@Override
	public int compareTo(Problem o1) {
		if(level==o1.level) {
			return time-o1.time;
		} else {
			return level-o1.level;
		}
		
	}


}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = 240;
		
		int[] solve = new int[6];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=5; i++) {
			solve[i] = Integer.parseInt(st.nextToken());
		}

		Problem[] problem = new Problem[N];

		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			problem[i] = new Problem(level, time);
		}

		Arrays.sort(problem);
		for(int i=0; i<N; i++) {
			if(solve[problem[i].level] > 0) {
				result += problem[i].time;
				solve[problem[i].level]--;
				if(solve[problem[i].level]>0) {
					result += (problem[i+1].time-problem[i].time);
				}
				// System.out.println(problem[i].level + " : " + problem[i].time);
			}
			
		}
		
		System.out.println(result);
	}

}