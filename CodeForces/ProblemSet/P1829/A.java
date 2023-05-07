import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];
        String cof = "codeforces";
        for (int t = 0; t < T; t++) {
            int result = 0;
            str[t] = br.readLine();
            for (int i = 0; i < str[t].length(); i++) {
                if (str[t].charAt(i) != cof.charAt(i)) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
