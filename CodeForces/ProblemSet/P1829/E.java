import java.io.*;
import java.util.*;

public class Main {

    public static int[][] visited;
    public static int[][] depth;
    public static int N, M;

    public static int BFS(int x, int y) {
        int[] move_x = { 0, 0, -1, 1 };
        int[] move_y = { -1, 1, 0, 0 };
        Queue<Integer> que_x = new LinkedList<Integer>();
        Queue<Integer> que_y = new LinkedList<Integer>();
        visited[x][y] = 1;
        que_x.add(x);
        que_y.add(y);
        int count = depth[x][y];
        while (!que_x.isEmpty() && !que_y.isEmpty()) {
            int tx = que_x.poll();
            int ty = que_y.poll();
            for (int i = 0; i < 4; i++) {
                int sx = tx + move_x[i];
                int sy = ty + move_y[i];
                if (sx >= 0 && sy >= 0 && sx < N && sy < M) {
                    if (visited[sx][sy] == 0 && depth[sx][sy] != 0) {
                        visited[sx][sy] = 1;
                        que_x.add(sx);
                        que_y.add(sy);
                        count += depth[sx][sy];
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new int[N][M];
            depth = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    depth[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == 0 && depth[i][j] != 0) {
                        int cc = BFS(i, j);
                        result = Math.max(result, cc);
                    }
                }
            }
            System.out.println(result);
        }
    }
}
