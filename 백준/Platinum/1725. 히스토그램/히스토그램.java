import java.util.*;
import java.io.*;
public class Main {
	public static int[] Tree;
	public static int[] arr;
	public static void makeTree(int left, int right, int node){
		if(left==right){Tree[node]=left;}
		else{
		int mid=(left+right)/2;
		makeTree(left, mid, node*2);
		makeTree(mid+1, right, node*2+1);
		if(arr[Tree[node*2]]<arr[Tree[node*2+1]]){
			Tree[node]=Tree[node*2];
		}
		else{
			Tree[node]=Tree[node*2+1];
		}
		}
	}

	public static int query(int s, int e, int i, int j, int node){
		if(e<i||s>j)return -1;
		else if(i<=s&&e<=j) return Tree[node];
		int mid=(s+e)/2;
		int lquery=query(s,mid, i, j,node*2);
		int rquery=query(mid+1,e,i,j,node*2+1);
		if(lquery==-1){
			return rquery;
		}
		else if(rquery==-1) return lquery;
		else if(arr[lquery]<arr[rquery]) return lquery;
		else return rquery;
		
	}
	
	public static long getArea(int s, int e){
		int N=arr.length-1;
		int ind=query(1,N,s,e,1);
		long area=(long)(e-s+1)*(long)arr[ind];
		if(s<ind){
			long temp=getArea(s,ind-1);
			area=Math.max(area,temp);
		}
		if(e>ind){
			long temp=getArea(ind+1,e);
			area=Math.max(area, temp);
		}
		return area;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}

		int h=(int)Math.ceil(Math.log(N)/Math.log(2));
		int ts=1;
		for(int j=0; j<h+1; j++){
			ts*=2;
		}

		Tree=new int[ts];
		
		makeTree(1,N,1);
		System.out.println(getArea(1,N));
	}

}
