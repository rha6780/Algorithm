import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] answer = new String[N];
        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<String>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                stack.add(st.nextToken());
            }
            answer[i] = "Case #" + (i + 1) + ": ";
            while (!stack.isEmpty()) {
                answer[i] += stack.pop() + " ";
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}