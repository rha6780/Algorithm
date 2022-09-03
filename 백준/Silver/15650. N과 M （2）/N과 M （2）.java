import java.util.*;
public class Main {

	public static int N=0, M=0;
	public static int[] visit;
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	
	public static void DP(int l, int a) {
		if(l==M) {
			for(int i=0; i<arr.size(); i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(i>=a) {
			if(visit[i]!=0) continue;
			
			visit[i]=1;
			arr.add(i);
			DP(l+1,i);
			visit[i]=0;
			arr.remove(arr.size()-1);}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		visit=new int[N+1];
		DP(0,0);
	}

}
