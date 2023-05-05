import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static long mod = 1_000_000_007;

    public static long exponent(long value, long ex) {
        long result = 1;
        while (ex > 0) {
            if (ex % 2 == 1) {
                result *= value;
                result %= mod;
            }
            value = (value * value) % mod;
            ex /= 2;
        }

        return result % mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long n = 1;
        long k = 1;

        for (int i = 0; i < K; i++) {
            n *= N;
            n %= mod;

            k *= (K - i);
            k %= mod;
            N--;
        }

        System.out.println((n * exponent(k, mod - 2)) % (mod));
    }
}