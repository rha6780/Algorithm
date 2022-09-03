import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Main  {
	public static int[] memo=new int[100001];//parent 를 저장
	public static ArrayList<ArrayList<Integer>> nn=new ArrayList<ArrayList<Integer>>();
	public static boolean[] visit=new boolean[100001];
	public static PriorityQueue<Integer> que=new PriorityQueue<>();
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static void findparent(int n) {
		int result=0, size=nn.get(n).size();
		for(int i=0; i<size; i++) {
			result=nn.get(n).get(i);
			if(visit[result]==false) {
				memo[result]=n;
				que.add((int)result);
				visit[result]=true;
			}
		}
		if(que.isEmpty()==false) {
			findparent(que.poll());
		}
		
	}
	public static void main(String[] args) {		
		int a=0, b=0;
		for(int i=0; i<N+1; i++) {
			nn.add(new ArrayList<Integer>());} 
		for(int i=1; i<N; i++) {
			a=sc.nextInt(); b=sc.nextInt();
			nn.get(a).add(b);
			nn.get(b).add(a);
		}
		findparent(1);
		for(int i=2; i<N+1; i++) {
			System.out.println(memo[i]);
		}
		
	}
}