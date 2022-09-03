import java.util.*;
public class Main {

	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	public static int[] visit=new int[20];
	public static void Dp(int l, int M, int a, int len, int[] t) {
		if(l==M) {
			for(int i=0; i<arr.size(); i++) {
				System.out.print(t[arr.get(i)]+" ");
			}
			System.out.println();
		}
		for(int j=0; j<len; j++) {
			if(t[j]>=a) {
			if(visit[j]!=0) continue;
			visit[j]=1;
			arr.add(j);
			Dp(l+1, M, t[j], len, t);
			visit[j]=0;
			arr.remove(arr.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=1;
		while(true) {
			n=sc.nextInt();
			if(n==0) {break;}
			int[] num=new int[n];
			for(int i=0; i<n; i++) {
				num[i]=sc.nextInt();
			}
			Dp(0, 6, 0, n, num);
			System.out.println();
		}

	}

}
