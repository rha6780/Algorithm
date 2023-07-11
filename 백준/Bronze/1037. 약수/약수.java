import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if (N == 1) {
            result = nums[0] * nums[0];
        } else {
            result = min * max;
        }

        System.out.println(result);
    }
}