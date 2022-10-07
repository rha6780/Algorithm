import java.io.*;
import java.util.*;

public class Main {

	public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
	public static int[] visit;
	public static boolean BFS(int a, int v) {
		int[] index=new int[v+1];
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(a);
		index[a]=1;
		visit[a]=1;
		while(!que.isEmpty()) {
			int q=que.poll();
			for(int i=0; i<arr.get(q).size(); i++) {
				int t=arr.get(q).get(i);
				visit[t]=1;
				if(index[t]==0) {
					que.add(t);
					if(index[q]==1)index[t]=2;
					else {index[t]=1;}
				}
				else {
					if(index[t]==index[q]) {
						return false;
					}
				}
				
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String r=br.readLine();
		StringTokenizer st=new StringTokenizer(r);
		int T=Integer.parseInt(st.nextToken());
		for(int i=0; i<T; i++){
			String s=br.readLine();
			st=new StringTokenizer(s);
			int V=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			visit=new int[V+1];
			arr.clear();
			for(int j=0; j<V+1; j++) {
				arr.add(new ArrayList<Integer>());
			}
			for(int j=0; j<E; j++) {
				String ss=br.readLine();
				st=new StringTokenizer(ss);
				int a=Integer.parseInt(st.nextToken()); 
				int b=Integer.parseInt(st.nextToken());
				arr.get(a).add(b);
				arr.get(b).add(a);
			}
			boolean ist=true;
			for(int k=1; k<V+1; k++) {
				if(visit[k]!=1) {
					ist=BFS(k,V);
					if(ist==false) {break;}
				}
			}
			if(ist)System.out.println("YES");
			else {System.out.println("NO");}
		}
	}

}
