import java.util.*;
public class Main {

	public static Long[] card;
	
	public static void main(String[] args) {
		PriorityQueue <Long> pque=new PriorityQueue<Long>();

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		card=new Long[N];
		for(int i=0; i<N; i++) {
			card[i]=sc.nextLong();
			pque.add(card[i]);
		}
		for(int i=0; i<M; i++) {
			long s1=pque.poll();
			long s2=pque.poll();
			long sum=s1+s2;
			
			pque.add(sum);pque.add(sum);
			
		}
		long sum=0;
		for(int i=0; i<N; i++) {
			sum+=pque.poll();
		}
		System.out.println(sum);
	}

}
