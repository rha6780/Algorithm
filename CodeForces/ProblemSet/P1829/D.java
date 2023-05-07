import java.io.*;
import java.util.*;

public class Main {

    public static boolean DP(int a, int g) {

        int n = a / 3;
        if (n == 0 || a % 3 != 0) {
            return false;
        }
        if (n == g || 2 * n == g) {
            return true;
        } else {
            return DP(n, g) || DP(2 * n, g);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == M) {
                System.out.println("YES");
                continue;
            }
            if (N % 3 == 1 || N < M) {
                System.out.println("NO");
            } else {
                if (DP(N, M)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
