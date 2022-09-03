import java.util.*;
import java.math.*;

public class Main {
	public static int[] Tree1;
	public static int[] Tree2;
	public static int[] data;
	public static int makeTree(int[] t, int left, int right, int node, int check) {
		if(left==right) {return t[node]=data[left];}
		int mid=(left+right)/2;
		if(check==0) {
			t[node]=Math.min(makeTree(t,left, mid, node*2, 0),makeTree(t,mid+1, right, node*2+1, 0));
		} else {
			t[node]=Math.max(makeTree(t,left, mid, node*2,1),makeTree(t,mid+1, right, node*2+1, 1));
		}
		return t[node];
	}
	public static int Query(int[] t,int node, int begin, int end, int left, int right, int check) {
		if(end<left||right<begin) {if(check==0) {return Integer.MAX_VALUE;} else{return Integer.MIN_VALUE;}}
		if(left<=begin&&end<=right) return t[node];
		int mid=(begin+end)/2;
		if(check==0) {
			return Math.min(Query(t, node*2, begin, mid, left, right, check),Query(t, node*2+1, mid+1, end, left, right, check)  );
		}
		else {
			return Math.max(Query(t, node*2, begin, mid, left, right, check),Query(t, node*2+1, mid+1, end, left, right, check)  );
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();

		Tree1=new int[300012]; data=new int[n+1];
		Tree2=new int[300012];
		int[][] ans=new int[m][2];
		for(int i=1; i<=n; i++) {
			data[i]=sc.nextInt();
		}
			makeTree(Tree1, 1, n, 1,0);
			makeTree(Tree2, 1, n, 1,1);
		for(int i=0; i<m; i++) {
			
			
			int a=sc.nextInt(); int b=sc.nextInt();
			ans[i][0]=Query(Tree1, 1,1,n, a,b, 0);
			ans[i][1]=Query(Tree2, 1,1,n, a,b, 1);
		}
		for(int i=0; i<m; i++) {
			System.out.println(ans[i][0]+" "+ans[i][1]);
		}
		
	}

}
