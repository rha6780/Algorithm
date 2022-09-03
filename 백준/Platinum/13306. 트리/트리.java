import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {

	public static int[] par=new int[10000];
	public static int[] rank=new int[10000];
	public static int find(int x){
		if(x==par[x]) return x;
		else{
			return par[x]=find(par[x]);
		}
	}
	public static void Union(int x, int y){
		x=find(x); y=find(y);
		if(x==y){return;}
		else{
			if(rank[x]>rank[y]){int tmp=x; x=y; y=tmp;}
			par[x]=y;
			if(rank[x]==rank[y]) ++rank[y];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String r=br.readLine();
		StringTokenizer st=new StringTokenizer(r);
		int N=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());
		par=new int[N+1];
		rank=new int[N+1];
		par[1]=1;
		int[] comm=new int[N+1];
		for(int i=1; i<N; i++) {
			par[i+1]=i+1;
			int p=Integer.parseInt(br.readLine());
			comm[i+1]=p;
		}
		String[] order=new String[Q+N];
		String[] result=new String[Q+N];
		for(int i=0; i<Q+N-1; i++) {
			String s=br.readLine();
			order[i]=s;
		}
		int count=0;
		for(int i=Q+N-2; i>=0; i--) {
			st=new StringTokenizer(order[i]);
			int y=Integer.parseInt(st.nextToken());
			if(y==0) {
				int d=Integer.parseInt(st.nextToken());
				Union(d, comm[d]);
			}
			else {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				if(find(a)==find(b)) {result[count]="YES"+"\n"; count++;}
				else {result[count]="NO"+"\n";count++;}
			}
		}
		for(int i=Q-1; i>=0; i--) {bw.write(result[i]);}
		bw.flush();
		
	}

}
