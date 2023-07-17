import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Integer[] nums = new Integer[n];
            boolean error = false;
            boolean reversed = false;

            Deque<Integer> deque = new ArrayDeque<Integer>();

            st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());

                deque.add(nums[j]);
            }

            for (int j = 0; j < command.length(); j++) {
                char com = command.charAt(j);
                if (com == 'R') {
                    reversed = !reversed;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reversed) {
                        deque.pollLast();
                    } else {
                        deque.pop();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
                // System.out.println("error");
            } else {
                if (deque.isEmpty()) {
                    sb.append("[]\n");
                    // System.out.println("[]");
                } else {
                    sb.append("[");
                    if (reversed) {
                        sb.append(deque.pollLast());
                    } else {
                        sb.append(deque.pop());
                    }

                    while (!deque.isEmpty()) {
                        if (reversed) {
                            sb.append(",").append(deque.pollLast());
                        } else {
                            sb.append(",").append(deque.pop());
                        }
                    }
                    sb.append("]\n");
                    // System.out.println("[" + result + "]");
                }
            }
        }
        System.out.println(sb);
    }
}