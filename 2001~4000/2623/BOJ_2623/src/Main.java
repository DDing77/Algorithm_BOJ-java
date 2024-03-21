import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    ArrayList<Integer>[] edges;
    int[] indegree;

    private List<Integer> getResult() {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            answer.add(cur);

            for (int next : edges[cur]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    que.add(next);
                }
            }
        }

        return answer;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to;
            for (int j = 0; j < size - 1; j++) {
                to = Integer.parseInt(st.nextToken());

                indegree[to]++;
                edges[from].add(to);

                from = to;
            }
        }

        List<Integer> res = getResult();

        if (res.size() != N) {
            System.out.println("0");
            return;
        }

        for (int num : res) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
