import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] fields = new int[N][N];
        int[][] sums = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                fields[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    if (j > 0) {
                        sums[i][j] = fields[i][j] + sums[i][j - 1];
                    } else {
                        sums[i][j] = fields[i][j];
                    }
                } else {
                    if (j > 0) {
                        sums[i][j] = fields[i][j] + sums[i][j - 1] + sums[i - 1][j] - sums[i - 1][j - 1];
                    } else {
                        sums[i][j] = fields[i][j] + sums[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = sums[x2 - 1][y2 - 1];
            if (x1 > 1 && y1 > 1) {
                result -= (sums[x2 - 1][y1 - 2] + sums[x1 - 2][y2 - 1] - sums[x1 - 2][y1 - 2]);
            } else {
                if (x1 > 1 && y1 <= 1) {
                    result -= sums[x1 - 2][y2 - 1];

                } else if (x1 <= 1 && y1 > 1) {
                    result -= sums[x2 - 1][y1 - 2];
                }
            }

            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}