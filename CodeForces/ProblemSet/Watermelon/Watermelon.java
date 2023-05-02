import java.io.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());

        if (weight % 2 != 0 || weight < 4) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}