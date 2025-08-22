import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N+1];
		int[] result = new int[N+1];


		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i=N-1; i>=0; i--) {
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				int max = stack.peek();
				if (num[i] < max) {
					result[i] = max;
				} else {
					while(!stack.isEmpty() && stack.peek() <= num[i]) {
						stack.pop();
					}

					if (stack.isEmpty()) {
						result[i] = -1;
					} else {
						result[i] = stack.peek();
					}
				}
			}
			
			stack.add(num[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			if (i==N-1) {
				sb.append(result[i]);	
			} else {
				sb.append(result[i] + " ");
			}
		}

		System.out.println(sb.toString());

	}

}
