import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> tree=new ArrayList<ArrayList<Integer>>();
		Queue<Integer> que=new LinkedList<Integer>();
		boolean[] visited=new boolean[N+1];
		int[] dis=new int[N+1];
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		for(int i=1; i<N; i++) {
			String s=br.readLine();
			StringTokenizer st=new StringTokenizer(s);
			int a=Integer.parseInt(st.nextToken()); int b=Integer.parseInt(st.nextToken());
			tree.get(a).add(b); tree.get(b).add(a);
		}
		long distance=0;
		
		que.add(1); visited[1]=true; dis[1]=0; 
		while(!que.isEmpty()) {
			int t=que.poll(); int count=0;
			for(int k=0;k<tree.get(t).size(); k++) {
				int y=tree.get(t).get(k);
				if(visited[y]!=true) {
					dis[y]=dis[t]+1;
					visited[y]=true;
					que.add(y);
					count++;
				}
			}
			if(count==0) {distance+=dis[t];}
		}
		
		if(distance%2!=0) {bw.write("Yes");}
		else {
			bw.write("No");
		}
		bw.flush();

	}

}
