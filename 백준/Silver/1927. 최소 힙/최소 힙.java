import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
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
