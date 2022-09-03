import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		PriorityQueue <Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				int res = Math.abs(o1)-Math.abs(o2);
				if(res==0) return o1-o2;
				else return res;
			}

			
		});
		
		for(int i=0; i<N; i++) {
			int a= sc.nextInt();
			if(a==0) {
				if(que.size()==0) {
					System.out.println(0);
				}
				else {
					System.out.println(que.poll());
				}
			}
			else {
				que.add(a);
			}
		}

	}

}
