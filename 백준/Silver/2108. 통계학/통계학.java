import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        sb.append((int) (Math.round(sum / (float) N))).append('\n');

        Arrays.sort(nums);
        sb.append(nums[N / 2]).append('\n');

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int ind = 0;
        boolean is_second = false;
        for (int i = 0; i < N; i++) {
            if (map.containsKey(nums[i])) {
                int tmp = map.get(nums[i]) + 1;
                map.put(nums[i], tmp);
            } else {
                map.put(nums[i], 1);
            }
            if (max < map.get(nums[i])) {
                ind = i;
                max = map.get(nums[i]);
                is_second = false;
            } else if (max == map.get(nums[i]) && !is_second) {
                ind = i;
                max = map.get(nums[i]);
                is_second = true;
            }
        }
        sb.append(nums[ind]).append('\n');
        sb.append(nums[N - 1] - nums[0]).append('\n');

        System.out.println(sb);
    }
}