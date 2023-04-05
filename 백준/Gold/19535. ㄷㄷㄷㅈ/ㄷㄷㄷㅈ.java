import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long cntD, cntG;
	static int[] siz;
	static int[][] query;
	static boolean[] isVisit;
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> diffis4 = new ArrayList<>();
	static long[][] comb;

	
	public static void combination(int n) {
		comb[0][0]=1;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=4; j++) {
				if(j==0) {comb[i][j]=1;}
				else {comb[i][j]=(comb[i-1][j-1]+comb[i-1][j]);}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		isVisit = new boolean[N+1];
		siz=new int[N+1]; query=new int[N+1][2];
		comb=new long[N+1][5];
		combination(N);
		for(int i=0; i<N+1; i++) {

			al.add(new ArrayList<>());
			diffis4.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			query[i+1][0]=node1; query[i+1][1]=node2;
			al.get(node1).add(node2);
			al.get(node2).add(node1);
			siz[node1]++; siz[node2]++;
		}
		
		for(int i=1; i<N+1; i++) {

			
			if(siz[query[i][0]]-1>0&&siz[query[i][1]]-1>0) {
				cntD+=(siz[query[i][0]]-1)*(siz[query[i][1]]-1);
			}
			
			//간선의 개수 중에 3개를 고르는 경우의 수
			if(siz[i] >= 3) {
				cntG += comb[siz[i]][3];
			}
		}
		
		//System.out.println(cntD+" "+cntG);
		if(cntD > 3*cntG) System.out.println("D");
		else if(cntD < 3*cntG) System.out.println("G");
		else System.out.println("DUDUDUNGA");
	}
	

}
