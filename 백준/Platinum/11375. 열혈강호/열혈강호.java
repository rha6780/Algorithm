import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static ArrayList<ArrayList<Integer>> aa=new ArrayList<ArrayList<Integer>>();
	public static boolean[] c=new boolean[1001];
	public static int[] bb=new int[1001];
	
	public static boolean dfs(int x) {
		for(int i=0; i<aa.get(x).size(); i++) {
		int t=aa.get(x).get(i);
		if(c[t])continue;
		c[t]=true;
		if(bb[t]==0||dfs(bb[t])) {bb[t]=x; return true;}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		for(int i=0; i<=N; i++) aa.add(new ArrayList<Integer>());
		for(int i=1; i<=N; i++) {
			int a=sc.nextInt();
			for(int j=0; j<a; j++) {
				int b=sc.nextInt();
				aa.get(i).add(b);
			}
		}
		int count=0;
		for(int i=1;i<=N; i++) {
			c=new boolean[1001];
			if(dfs(i)) count++;
		}
		System.out.println(count);
	}

}
