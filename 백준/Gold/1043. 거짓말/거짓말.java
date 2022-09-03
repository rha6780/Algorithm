import java.util.*;
import java.io.*;

public class Main {
	public static int[] par=new int[10000];
	public static int find(int x) {
		if(par[x]==x)return x;
		else {
			return par[x]=find(par[x]);
		}
	}
	public static void Union(int x, int y) {
		x=find(x); y=find(y);
		if(x>y) {
			int tmp=x;
			x=y; y=tmp;
		}
		if(x!=y) {par[y]=x;}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		for(int i=0; i<=N; i++) {par[i]=i;}
		for(int i=0; i<K; i++) {par[sc.nextInt()]=0;}
		for(int i=0; i<M; i++) {arr.add(new ArrayList<Integer>());}
		for(int i=0; i<M; i++) {
			int n=sc.nextInt();
			for(int j=0; j<n; j++) {
				arr.get(i).add(sc.nextInt());
				if(j>0) {
					Union(arr.get(i).get(j-1),arr.get(i).get(j));
					//System.out.println(arr.get(i).get(j-1)+" "+arr.get(i).get(j));
				}
			}
		}
		int result=0;
		for(int i=0; i<M; i++) {
			boolean isf=false;
			for(int h=0; h<arr.get(i).size(); h++) {
				int a=arr.get(i).get(h);
				if(find(a)==0) {isf=true;}
			}
			if(isf==false) {result++;}
		}
		System.out.print(result);
		

	}

}
