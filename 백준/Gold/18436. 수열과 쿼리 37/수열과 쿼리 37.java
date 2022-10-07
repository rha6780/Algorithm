import java.util.*;

public class Main {
	
	public static int[] tree;
	public static int[] data;
	public static int init(int node, int begin, int end){
		
		if(begin==end) {if(data[begin]%2==0){return tree[node]=1;}else{return tree[node]=0;}}
		int mid=(begin+end)/2;
		return tree[node]=init(node*2, begin, mid)+init(node*2+1, mid+1, end);
	}
	public static void update(int node, int begin, int end, int index, int diff){
		if(index<begin||end<index) return;
		tree[node]+=diff;
		if(begin==end) return;
		else if(begin!=end){
		int mid=(begin+end)/2;
		update(node*2, begin, mid, index, diff);
		update(node*2+1, mid+1, end, index, diff);}
	}
	public static int count(int node, int start, int end, int left, int right){
		if(left>end||right<start){
			return 0;
		} 
		if(left<=start&&end<=right){
			return tree[node];
		}
		int mid=(start+end)/2;
		return count(node*2, start, mid, left, right)+count(node*2+1, mid+1, end, left, right);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		tree=new int[40000001];
		data=new int[N+1];
		for(int i=1; i<=N; i++){
			data[i]=sc.nextInt();
		}
		init(1, 1, N);
		int M=sc.nextInt();
		for(int i=0; i<M; i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int d=0;
			if(a==1){if(data[b]%2!=0&&c%2==0){d=1;}
			else if(data[b]%2==0&&c%2!=0){d=-1;}
				data[b]=c; update(1,1,N,b,d); }
			else if(a==2){System.out.println(count(1,1,N,b,c));}
			else{System.out.println(c-b+1-count(1,1,N,b,c));}
		}
		
	}

}
