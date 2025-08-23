import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			switch (command) {
				case 1:
					int x = Integer.parseInt(st.nextToken());
					stack.add(x);
					break;
				case 2:
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						int target = stack.pop();
						sb.append(target).append("\n");
					}
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					break;
				case 4:
					sb.append(stack.isEmpty() == true ? 1 : 0).append("\n");
					break;
				default:
					if (stack.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(stack.peek()).append("\n");
					}
					break;
			}
			

		}

		System.out.println(sb);
	}

}

