import java.io.*;
import java.util.*;

public class Main {

    public static long mod = 1_000_000_007;
    public static long[] fac;

    public static long exponent(long value, long ex) {
        if (ex == 0) {
            return 1;
        } else if (ex == 1) {
            return value;
        } else {
            if (ex % 2 == 1) {
                long tmp = exponent(value, ex - 1);
                return (tmp * value) % mod;
            } else {
                long tmp = exponent(value, ex / 2);
                return (tmp * tmp) % mod;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        fac = new long[(int) (4 * 1e6 + 1)];
        fac[0] = 1;
        fac[1] = 1;

        for (int i = 2; i < (int) (4 * 1e6 + 1); i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }

        int M = Integer.parseInt(br.readLine());

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            sb.append((fac[N] * exponent(fac[N-K]*fac[K]%mod, mod - 2)) % (mod)).append("\n");
        }

        System.out.println(sb);
    }
}