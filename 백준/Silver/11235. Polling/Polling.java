import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> candidates = new HashMap<String, Integer>();

        int max = 1;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (candidates.containsKey(name)) {
                int value = candidates.get(name);
                candidates.put(name, value + 1);
                max = Math.max(value + 1, max);
            } else {
                candidates.put(name, 1);
            }
        }
        ArrayList<String> names = new ArrayList<String>(candidates.keySet());
        Collections.sort(names);
        for (String n : names) {
            if (candidates.get(n) == max) {
                System.out.println(n);
            }
        }

    }
}