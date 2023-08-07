import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        HashSet<Integer> S = new HashSet<Integer>();
        HashSet<Integer> T = new HashSet<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NA; i++) {
            S.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NB; i++) {
            T.add(Integer.parseInt(st.nextToken()));
        }

        S.removeAll(T);

        ArrayList<Integer> U = new ArrayList<Integer>(S);
        Collections.sort(U);

        if (0 == S.size()) {
            System.out.print("0");
        } else {
            System.out.println(S.size());
            for (Object s : U) {
                System.out.print(s + " ");
            }
        }
    }
}