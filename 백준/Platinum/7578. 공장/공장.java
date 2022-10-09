import java.io.*;
import java.util.*;

public class Main {
    public static long[] Tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A_Machine = new int[N + 1];
        HashMap<Integer, Integer> B_Machine = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A_Machine[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            B_Machine.put(Integer.parseInt(st.nextToken()), i);
        }

        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treesize = 1;
        for (int i = 0; i <= height; i++) {
            treesize *= 2;
        }
        Tree = new long[treesize];

        long result = 0;
        for (int i = 1; i <= N; i++) {
            int machine_id = A_Machine[i];
            int match_index = B_Machine.get(machine_id);

            result += sum(1, N, 1, match_index + 1, N);
            update(1, N, 1, match_index, 1);
        }

        System.out.println(result);

    }

    public static long sum(int s, int e, int node, int left, int right) {
        if (e < left || right < s) {
            return 0;
        }
        if (left <= s && e <= right) {
            return Tree[node];
        }

        int mid = (s + e) / 2;
        return sum(s, mid, node * 2, left, right) + sum(mid + 1, e, node * 2 + 1, left, right);
    }

    public static void update(int s, int e, int node, int index, int diff) {
        if (index < s || e < index) {
            return;
        }

        Tree[node] += diff;

        if (s != e) {
            int mid = (s + e) / 2;
            update(s, mid, node * 2, index, diff);
            update(mid + 1, e, node * 2 + 1, index, diff);
        }
    }
}