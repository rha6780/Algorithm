import java.util.Deque;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Deque<Integer> deque=new LinkedList<Integer>();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String s="";
		for(int i=0; i<N; i++) {
			s=sc.next();
			if(s.equals("push_back")) {
				int a=sc.nextInt();
				deque.addLast(a);
			}
			else if(s.equals("push_front")) {
				int a=sc.nextInt();
				deque.addFirst(a);
			}
			else if(s.equals("pop_front")) {
				if(!deque.isEmpty()) {
					System.out.println(deque.pollFirst());
				}
				else {System.out.println(-1);}
			}
			else if(s.equals("pop_back")){
				if(!deque.isEmpty()) {
					System.out.println(deque.pollLast());
				}
				else {System.out.println(-1);}
			}
			else if(s.equals("size")) {
				System.out.println(deque.size());
			}
			else if(s.equals("empty")) {
				if(!deque.isEmpty()) {System.out.println(0);}
				else {System.out.println(1);}
			}
			else if(s.equals("front")) {
				if(!deque.isEmpty()) {System.out.println(deque.peekFirst());}
				else {System.out.println(-1);}
			}
			else if(s.equals("back")) {
				if(!deque.isEmpty()) {System.out.println(deque.peekLast());}
				else {System.out.println(-1);}
			}
			}
	}

}
