import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int five_count = 0;

        while (N >= 5) {
            five_count += N / 5;
            N /= 5;
        }
        answer = five_count;
        System.out.println(answer);
    }
}