import java.io.*;
import java.util.*;

public class Main {

    public static int[] count;
    public static int[][] graph;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = new int[N + 1];
            graph = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
                graph[b][a] = 1;
                count[a]++;
                count[b]++;
            }
            int temp = 0;
            for (int i = 1; i <= N; i++) {
                if (count[i] == 1) {
                    temp++;
                }
            }
            int x = N - temp - 1;
            int y = temp / x;
            System.out.println(x + " " + y);
        }
    }
}
