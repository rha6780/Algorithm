import java.io.*;
import java.util.*;

public class Main {

    private static int[] movex = { 0, 0, -1, 1 };
    private static int[] movey = { -1, 1, 0, 0 };
    private static int[][] fields;
    private static int[][] answer;
    private static boolean[][] visited;

    static void BFS(int x, int y, int N, int M) {
        Queue<Integer> quex = new LinkedList<Integer>();
        Queue<Integer> quey = new LinkedList<Integer>();

        quex.add(x);
        quey.add(y);
        visited[x][y] = true;
        answer[x][y] = 0;

        while (!quex.isEmpty() && !quey.isEmpty()) {
            int tx = quex.poll();
            int ty = quey.poll();
            for (int i = 0; i < 4; i++) {
                int xx = tx + movex[i];
                int yy = ty + movey[i];
                if (xx >= 0 && xx < N && yy >= 0 && yy < M && !visited[xx][yy] && fields[xx][yy] == 1) {
                    quex.add(xx);
                    quey.add(yy);
                    answer[xx][yy] = answer[tx][ty] + 1;
                    visited[xx][yy] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        fields = new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];
        int stx = 0;
        int sty = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                fields[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
                if (fields[i][j] == 2) {
                    stx = i;
                    sty = j;
                }
            }
        }
        BFS(stx, sty, N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    System.out.print(answer[i][j] + " ");
                } else if (fields[i][j] == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }

    }
}