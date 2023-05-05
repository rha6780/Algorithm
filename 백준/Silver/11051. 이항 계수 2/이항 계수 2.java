import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BigInteger n = BigInteger.ONE;
        BigInteger k = BigInteger.ONE;

        for (int i = 0; i < K; i++) {
            n = n.multiply(BigInteger.valueOf(N));
            k = k.multiply(BigInteger.valueOf(K - i));
            N--;
        }

        BigInteger result = n.divide(k).remainder(BigInteger.valueOf(10007));
        System.out.println(result.intValue());
    }
}