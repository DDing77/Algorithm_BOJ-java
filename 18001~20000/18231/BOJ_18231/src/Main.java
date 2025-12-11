import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private ArrayList<Integer>[] graph;
    private int K;
    private boolean[] destroyed;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        K = Integer.parseInt(br.readLine());
        destroyed = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            destroyed[x] = true;
        }

        ArrayList<Integer> candidate = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!destroyed[i]) {
                continue;
            }

            boolean valid = true;
            for (int nxt : graph[i]) {
                if (!destroyed[nxt]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                candidate.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!destroyed[i]) {
                continue;
            }

            boolean covered = destroyed[i] && candidate.contains(i);

            if (!covered) {
                for (int nxt : graph[i]) {
                    if (candidate.contains(nxt)) {
                        covered = true;
                        break;
                    }
                }
            }

            if (!covered) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(candidate.size());
        for (int x : candidate) {
            sb.append(x).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
