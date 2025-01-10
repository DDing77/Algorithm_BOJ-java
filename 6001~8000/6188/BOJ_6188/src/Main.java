import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int C;
    private ArrayList<Integer>[] edges;
    private int[] distances;

    private void execBFS() {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 1});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            distances[cur[0]] = cur[1];
            for (int next : edges[cur[0]]) {
                que.add(new int[]{next, cur[1] + 1});
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        distances = new int[N];
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            edges[from].add(left);
            edges[from].add(right);
        }

        execBFS();

        for (int distance : distances) {
            sb.append(distance).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
