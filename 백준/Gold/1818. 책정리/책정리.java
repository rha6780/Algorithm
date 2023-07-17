import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] books = new int[N];
        int[] lis = new int[N + 1];

        for (int t = 0; t < N; t++) {
            books[t] = Integer.parseInt(st.nextToken());
        }
        lis[0] = books[0];

        int count = 1;
        for (int i = 0; i < N; i++) {
            if (lis[count - 1] < books[i]) {
                lis[count] = books[i];
                count++;
            } else {
                int left = 0;
                int right = count;
                while (left <= right) {
                    int mid = ((left + right) / 2);
                    if (lis[mid] < books[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                lis[left] = books[i];
            }
        }

        System.out.println(N - count);
    }
}