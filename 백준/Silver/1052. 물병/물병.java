import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;

        while (true) {
            int count = 0;
            int bottle = N + result;
            while (bottle > 0) {
                int rest = bottle % 2;
                bottle /= 2;
                if (rest == 1) {
                    count++;
                }
            }
            if (count <= K) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}