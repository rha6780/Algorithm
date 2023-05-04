import java.io.*;
import java.util.*;

public class Team {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[][] confidence = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int conf = Integer.parseInt(st.nextToken());
                confidence[i][j] = conf;
            }
        }

        for (int i = 0; i < N; i++) {
            if (confidence[i][0] + confidence[i][1] + confidence[i][2] >= 2) {
                result++;
            }
        }
        System.out.println(result);
    }
}