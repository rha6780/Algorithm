import java.io.*;
import java.util.*;

public class Main {

    // public static Queue<Character> result = new LinkedList<Character>();
    public static StringBuilder sb = new StringBuilder();
    public static String A, B;

    public static void FindLCS(int[][] lcs, int x, int y) {
        if (x == 0 || y == 0) {
            return;
        }
        if (lcs[x - 1][y] == lcs[x][y - 1]) {
            if (lcs[x][y] == lcs[x - 1][y]) {
                FindLCS(lcs, x - 1, y);
            } else if (lcs[x][y] - 1 == lcs[x - 1][y]) {
                sb.append(A.charAt(x - 1));
                FindLCS(lcs, x - 1, y - 1);
            }
        } else {
            if (lcs[x - 1][y] > lcs[x][y - 1]) {
                FindLCS(lcs, x - 1, y);
            } else {
                FindLCS(lcs, x, y - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        int[][] LCS = new int[A.length() + 1][B.length() + 1];
        int a_len = A.length();
        int b_len = B.length();

        for (int i = 0; i <= a_len; i++) {
            for (int j = 0; j <= b_len; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    } else {
                        LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                    }
                }
            }
        }

        FindLCS(LCS, a_len, b_len);

        System.out.println(LCS[a_len][b_len]);
        System.out.println(sb.reverse());
    }
}