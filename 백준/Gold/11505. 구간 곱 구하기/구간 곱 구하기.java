import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {

	public static int rest=1000000007;
	public static int[] arr;
	public static long[] Tree;
	
	public static long makeTree(int l, int r, int node){
		if(l==r){return Tree[node]=(long)arr[l];}
		int mid=(l+r)/2;
		Tree[node]=1;
		Tree[node]=makeTree(l,mid,node*2)%rest;
		Tree[node]*=makeTree(mid+1, r, node*2+1)%rest;
		return Tree[node]%=rest;
	}
	public static long query(int s, int e, int l, int r, int node){
		if(e<l||r<s){return 1;}
		if(l<=s&&e<=r){return Tree[node];}
		int mid=(s+e)/2;
		return (query(s,mid,l,r,node*2)%rest)*(query(mid+1,e, l,r,node*2+1)%rest)%rest;
	}
	
	public static long update(int s, int e, int l, int r, int node, int index, int diff){
		if(!(index>=s&&e>=index)){return Tree[node];}
		
		if(s==e){return Tree[node]=diff;}
		int mid=(s+e)/2;
		return Tree[node]=(update(s,mid,l,r,node*2,index, diff)%rest*update(mid+1,e,l,r,node*2+1, index, diff)%rest)%rest;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken()); int K=Integer.parseInt(st.nextToken());
		arr=new int[N+1]; 
		int height=(int)Math.ceil(Math.log(N)/Math.log(2));
		int treesize=1;
		for(int k=0; k<height+1; k++){treesize*=2;}
		Tree=new long[treesize];
		
		for(int i=1; i<=N; i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		makeTree(1,N,1);
		for(int i=0; i<M+K; i++){
			s=br.readLine();
			st=new StringTokenizer(s);
			int a=Integer.parseInt(st.nextToken()); int b=Integer.parseInt(st.nextToken()); int c=Integer.parseInt(st.nextToken());
			if(a==1){update(1,N,1,N,1,b,c);arr[b]=c;} 
			else if(a==2){bw.append(query(1,N,b,c,1)+"\n");}
		}
		bw.flush();

	}

}
