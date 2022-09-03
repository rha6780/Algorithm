import java.util.*;
import java.io.*;
public class Main {

	public static int[] par=new int[10000];
	public static int[] visit=new int[100000];
	public static int[] flag=new int[10000];
	public static int result=0;
	public static int find(int x) {
		if(par[x]==x) {return x;}
		else {
			return par[x]=find(par[x]);
		}
	}
	public static void Union(int x, int y) {
		x=find(x); y=find(y);
		if(x>y) {int tmp=x; x=y; y=tmp;}
		if(x==y) {flag[x]++;return;}
		else if(x!=y) {par[y]=x; flag[x]+=flag[y]; }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int ind=1;
		while(true) {
		result=0;
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		int N=Integer.parseInt(st.nextToken()); 
		int M=Integer.parseInt(st.nextToken());
		if(N==0&&M==0) {break;}
		par=new int[N+1];visit=new int[N+1];
		flag=new int[N+1];
		for(int i=0; i<N+1; i++) {par[i]=i;}
		for(int i=0; i<M; i++) {
			String r=br.readLine();
			st=new StringTokenizer(r);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			Union(a,b);
		}
		for(int i=1; i<N+1; i++) {
			int a=find(i);
			if(visit[a]!=1&&flag[a]==0) {result++; visit[a]=1;}
			//System.out.println(i+" "+result);
		}
		System.out.print("Case "+ind+": ");
		if(result==0) {System.out.println("No trees.");}
		else if(result==1) {System.out.println("There is one tree.");}
		else if(result>1) {System.out.println("A forest of "+result+" trees.");}
		
		ind++;
		}
		
	}

}
