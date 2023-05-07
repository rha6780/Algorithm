import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] time = new int[N];
            int[] skill = new int[N];
            int result = 2_000_000;
            int min_one = 2_000_000;
            int min_two = 2_000_000;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                time[i] = Integer.parseInt(st.nextToken());
                skill[i] = Integer.parseInt(st.nextToken());
                // System.out.println(skill[i]);
                if (skill[i] == 11) {
                    result = Math.min(result, time[i]);
                }
                if (skill[i] == 10) {
                    min_one = Math.min(min_one, time[i]);
                }
                if (skill[i] == 1) {
                    min_two = Math.min(min_two, time[i]);
                }
            }

            result = Math.min(result, min_one + min_two);
            if (result == 2_000_000) {
                result = -1;
            }
            System.out.println(result);
        }
    }
}
