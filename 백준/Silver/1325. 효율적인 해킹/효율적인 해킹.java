import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean[] visit=new boolean[10001];
	public static int[] max=new int[10001];
	public static ArrayList<Integer>[] arr=new ArrayList[10001];
	
	public static void DFS(int a) {
		visit[a]=true;
		for(int i: arr[a]) {
			if(visit[i]==false) {max[i]++; DFS(i);}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//StringBuilder sb = new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}
		int Max=0;
		for(int i=1; i<=N; i++) {visit=new boolean[N+1];DFS(i);}
		for(int i=1; i<=N; i++) {if(Max<max[i]) {Max=max[i];}}

		for(int i=1; i<=N; i++) {
			//System.out.println(i+" "+max[i]);
			if(Max==max[i]) {bw.write(i+" ");}
		}
		bw.flush();
		bw.close();

	}

}
