import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[N+1];
		int[] times = new int[N+1];
		int[] result = new int[N+1];

		for (int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) {break;}
				graph.get(num).add(i);
				indegree[i]++;
			}
		}

		Queue<Integer> que = new LinkedList<Integer>();

		for(int i=1; i<=N; i++) {
			if (indegree[i] == 0) {
				que.add(i);
			}
		}

		while (!que.isEmpty()) {
			int now = que.poll();
			
			for (int j : graph.get(now)) {
				result[j] = Math.max(result[j], (result[now] + times[now]));
				indegree[j]--;
				if (indegree[j] == 0) {
					que.add(j);
				}
			}
		}

		for(int i=1 ; i<=N; i++) {
			System.out.println(result[i] + times[i]);
		}

	}

}