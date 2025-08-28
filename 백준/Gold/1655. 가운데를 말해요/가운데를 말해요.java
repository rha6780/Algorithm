import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> max = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
		PriorityQueue<Integer> min = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());

			if(max.size() == min.size()) { max.offer(a);}
			else {
				min.offer(a);
			}

			if (!max.isEmpty() && !min.isEmpty()) {
				if (max.peek() > min.peek()) {
					int maxq = max.poll();
					int minq = min.poll();
					max.offer(minq);
					min.offer(maxq);
				}
			}
			sb.append(max.peek() + "\n");
		}
		System.out.println(sb.toString());
	}

}