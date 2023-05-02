import java.io.*;

public class WayTooLongWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] abbreviations = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int len = word.length();
            if (len > 10) {
                char[] charaters = word.toCharArray();
                abbreviations[i] = "";
                abbreviations[i] += charaters[0] + String.valueOf(len - 2) + charaters[len - 1];
            } else {
                abbreviations[i] = word;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(abbreviations[i]);
        }
    }
}
