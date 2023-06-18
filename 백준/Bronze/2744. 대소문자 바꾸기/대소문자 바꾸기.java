import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String answer = "";
        for (char c : str.toCharArray()) {
            String ss = String.valueOf(c);
            if (ss.toLowerCase() == ss) {
                answer += ss.toUpperCase();
            } else {
                answer += ss.toLowerCase();
            }
        }
        System.out.println(answer);

    }
}