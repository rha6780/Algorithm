import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {

	public static int[] Tree=new int[3000001];
	public static int[] arr=new int[1000001];
	
	public static int makeTree(int l, int r, int node){
		if(l==r){
			return Tree[node]=arr[l];
		}
		int mid=(l+r)/2;
		Tree[node]+=Math.min(makeTree(l,mid,node*2),makeTree(mid+1,r,node*2+1));
		return Tree[node];
		
	}
	
	public static int query(int s, int e, int l, int r, int node){
		if(e<l||r<s){return Integer.MAX_VALUE;}
		if(l<=s&&e<=r){return Tree[node];}
		int mid=(s+e)/2;
		return Math.min(query(s, mid, l, r,node*2),query(mid+1, e, l, r, node*2+1));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer t=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(t.nextToken());
		int M=Integer.parseInt(t.nextToken());
		
		for(int i=1; i<N+1; i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		makeTree(1,N,1);
		for(int i=0; i<M; i++){
			String s=br.readLine();
			t=new StringTokenizer(s);
			int a=Integer.parseInt(t.nextToken()); int b=Integer.parseInt(t.nextToken());
			bw.append(query( 1, N, a, b, 1)+"\n");
		}
		bw.flush();
		
	}

}
