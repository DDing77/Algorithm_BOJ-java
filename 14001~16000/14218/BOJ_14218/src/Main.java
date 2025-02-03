import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int Q;
    private ArrayList<Integer>[] edges;
    private boolean[] isVisited;
    private int[] distances;

    private void execBFS() {

        isVisited = new boolean[N + 1];
        isVisited[1] = true;



        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            distances[cur[0]] = cur[1];

            for (int next : edges[cur[0]]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }

        distances = new int[N + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);

            execBFS();

            for (int j = 1; j <= N; j++) {
                sb.append(distances[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
