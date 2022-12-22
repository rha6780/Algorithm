import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new LinkedList<Integer>();
        int N = Integer.parseInt(br.readLine());
        String commend = " ";
        int c = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            commend = st.nextToken();
            if (commend.equals("push")) {
                c = Integer.parseInt(st.nextToken());
                que.add(c);
            } else if (commend.equals("front")) {
                if (!que.isEmpty())
                    bw.write(que.peek() + "\n");
                else
                    bw.write(-1 + "\n");
            } else if (commend.equals("back")) {
                if (que.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(c + "\n");
            } else if (commend.equals("pop")) {
                if (que.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(que.poll() + "\n");
            } else if (commend.equals("empty")) {
                if (que.isEmpty())
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            } else
                bw.write(que.size() + "\n");
        }
        bw.flush();
    }
}