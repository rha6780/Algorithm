import java.io.*;
import java.util.*;

public class Main {

    public static long mod = 1_000_000_007;

    public static long exponent(long value, long ex) {
        if (ex == 0) {
            return 1;
        } else {
            long tmp = exponent(value, ex / 2);
            if (ex % 2 == 1) {
                return (((tmp * tmp) % mod) * value) % mod;
            }
            return (tmp * tmp) % mod;
        }
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