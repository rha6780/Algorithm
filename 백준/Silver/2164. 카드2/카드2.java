import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] card=new int[N+3];
		Queue<Integer> que=new LinkedList<Integer>();
		for(int i=1; i<=N; i++){
			card[i]=i;
			que.add(i);
		}
		int count=0;
		
		while(!que.isEmpty()){
			if(que.size()==1){System.out.println(que.poll());break;}
			que.poll();
			int a=que.poll();
			que.add(a);
			count++;

			
		}
	}

}
