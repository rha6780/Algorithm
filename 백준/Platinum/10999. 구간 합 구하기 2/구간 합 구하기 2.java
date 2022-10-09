import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long[] Tree;
    public static long[] num;
    public static long[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        num = new long[N + 1];

        Tree = new long[N * 4];
        lazy = new long[N * 4];

        for (int i = 1; i <= N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        makeTree(1, N, 1);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (b > c) {
                int temp = c;
                c = b;
                b = temp;
            }
            if (st.hasMoreTokens() && a == 1) {
                long d = Long.parseLong(st.nextToken());
                update_range(1, 1, N, b, c, d);
            } else {
                System.out.println(sum(1, N, 1, b, c));
            }
        }
    }

    public static void makeTree(int left, int right, int node) {
        if (left == right) {
            Tree[node] = num[left];
        } else {
            int mid = (left + right) / 2;
            makeTree(left, mid, node * 2);
            makeTree(mid + 1, right, node * 2 + 1);
            Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
        }
    }

    public static long sum(int s, int e, int node, int left, int right) {
        update_lazy(node, s, e);
        if (e < left || right < s) {
            return 0;
        }
        if (left <= s && e <= right) {
            return Tree[node];
        }

        int mid = (s + e) / 2;
        return sum(s, mid, node * 2, left, right) + sum(mid + 1, e, node * 2 + 1, left, right);
    }

    public static void update_lazy(int node, int begin, int end) {
        if (lazy[node] != 0) { // 업데이트 할 값이 있다면
            Tree[node] += (end - begin + 1) * lazy[node]; // 업데이트한다.
            if (begin != end) { // 단말 노드가 아니라면, 즉 자식 노드가 있다면
                lazy[node * 2] += lazy[node]; // 왼쪽 자식 노드에 추후 저장할 값을 지정한다.
                lazy[node * 2 + 1] += lazy[node]; // 오른쪽 자식 노드에 추후 저장할 값을 지정한다.
            }
            lazy[node] = 0; // 업데이트 했으므로 현재 노드의 갱신값을 제거한다.
        }
    }

    public static void update_range(int node, int begin, int end, int left, int right, long diff) {
        //System.out.println("범위 업데이트:" + left + "~" + right + "에 대한:" + begin + "~" + end + "업데이트:" + diff);
        update_lazy(node, begin, end); // 현재 방문한 node에 대한 게으른 갱신을 진행한다.
        if (end < left || right < begin)
            return; // 제한 범위 외인 경우 이상 범위로 return
        if (left <= begin && end <= right) { // 범위 안인 경우
            Tree[node] += (long) (end - begin + 1) * diff; // 구간 범위를 모두 업데이트 값을 더한
            if (begin != end) { // 자식 노드가 있는 경우 갱신 값을 각각 전달한다.
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }
        // 범위 밖인 경우 원하는 범위가 나올때 까지 쪼갠다.
        int mid = (begin + end) / 2;
        update_range(node * 2, begin, mid, left, right, diff);
        update_range(node * 2 + 1, mid + 1, end, left, right, diff);
        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }
}
