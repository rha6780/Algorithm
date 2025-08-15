import java.util.*;
import java.io.*;

public class Main {

	public static int N, M, R, count;
	public static int[] result;
	public static boolean[] visit;
	public static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());


		visit = new boolean[N+1];
		result = new int[N+1];

		for (int i = 0; i <=N; i++) {
			graph.add(new ArrayList<Integer>());
			visit[i] = false;
		}

		for (int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}

		for (int i = 0; i <=N; i++) {
			Collections.sort(graph.get(i));
		}
 
		count = 1;
		result[R] = count;
		dfs(R);

		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
	}


	public static void dfs(int c) {
		if(visit[c]) {return;}
		visit[c]=true;
		for(int i=0; i<graph.get(c).size(); i++) {
			int p=graph.get(c).get(i);
			if(visit[p]==false) {//역으로 가서 방문한 적이 있는지 본다.
				result[p]=++count;
				dfs(p);
			}
		}
	}

}