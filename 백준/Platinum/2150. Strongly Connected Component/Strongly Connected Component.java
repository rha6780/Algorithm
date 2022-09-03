import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<ArrayList<Integer>> rdigraph = new ArrayList<>(); // 역방향 그래프
	static ArrayList<ArrayList<Integer>> digraph = new ArrayList<>(); // 방향 그래프
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        for (int i = 0; i <= V; i++) {
            digraph.add(new ArrayList<>());
            rdigraph.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }

        // 단방향 인접리스트 구현 (방향 그래프, 역방향 그래프)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            digraph.get(a).add(b);
            rdigraph.get(b).add(a);
        }

        visited = new boolean[V + 1];
        stack = new Stack<>();

        // 방향 그래프에 대하여 dfs를 수행하고,
        // 탐색이 종료되는 점부터 스택에 push함.
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Arrays.fill(visited, false);
        int groupNum = 0;

        // 역방향으로 대하여 dfs 수행.
				// 부모 노드로 돌아갈 수 있는지.
        while (!stack.isEmpty()) {
            int start = stack.pop();
            // 방문 체크된 것은 이미 SCC 그룹에 속해 있다는 뜻.
            if (visited[start]) {continue;}

            redfs(start, groupNum);
            groupNum++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(groupNum + "\n"); // SCC 그룹의 개수 출력.
        
        TreeMap<Integer, Integer> map = new TreeMap<>(); // key를 기준으로 오름차순 정렬.
        for (int i = 0; i < groupNum; i++) {
            Collections.sort(res.get(i)); // 각각의 SCC 그룹에 대해 오름차순 정렬.
            map.put(res.get(i).get(0), i); // key : SCC 그룹의 첫번째 항, value : 인덱스.
        }

        // map의 첫번째 항이 작은 순서.
        map.keySet().forEach(key -> {
            int value = map.get(key);

            for (int now : res.get(value)) {
                sb.append(now + " ");
            }
            sb.append("-1\n"); // 끝에 -1 붙여주는 것 잊지 말기.
        });

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    
    // 끝나는 점에 대해 stack push.
    public static void dfs (int start) {
        visited[start] = true;

        for (int now : digraph.get(start)) {
            if (!visited[now]) {
                dfs(now);
            }
        }

        stack.push(start);
    }

    // 결과값을 담는 코드. SCC 그룹 별
    public static void redfs(int start, int groupNum) {
        visited[start] = true;
        res.get(groupNum).add(start);

        for (int now : rdigraph.get(start)) {
            if (!visited[now]) {
                redfs(now, groupNum);
            }
        }
    }
}