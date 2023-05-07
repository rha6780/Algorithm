
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] seg = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                seg[i] = Integer.parseInt(st.nextToken());
                if (seg[i] == 0) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 0;
                }
            }
            result = Math.max(result, count);
            System.out.println(result);
        }
    }
}
