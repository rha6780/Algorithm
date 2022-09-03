import java.util.*;

public class Main {
	
	public static int N=0, S=0;
	public static int[] visit;
	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	public static int result=0;
	public static int[] num;
	
	public static void DP(int l,int m,int a, int b) {
		if(l==m) {
			int sum=0; boolean is=false;
			for(int i=0; i<arr.size(); i++) {
				sum+=arr.get(i);
				is=true;
			}
			if(is&&sum==S) {result++;}
			return;
		}
		
		for(int i=b; i<=N; i++) {
			if(num[i-1]>=a) {
			if(visit[i]!=0) continue;

			visit[i]=1;
			arr.add(num[i-1]);
			DP(l+1,m,num[i-1],i+1);
			arr.remove(arr.size()-1);
			visit[i]=0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); S=sc.nextInt();
		num=new int[N]; visit=new int[N+1];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		Arrays.sort(num);
		for(int j=0; j<=N; j++) {
			visit=new int[N+1];
			DP(0,j,-1000001,1);
		}
		
		System.out.println(result);
		
	}

}
