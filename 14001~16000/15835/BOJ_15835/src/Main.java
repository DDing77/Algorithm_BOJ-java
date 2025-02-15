import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int M;

    private PriorityQueue<int[]> edges;
    private int[] parents;
    private int res;

    private int find(int x) {

        if (parents[x] < 0) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private boolean union(int x, int y) {

        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (parents[x] <= parents[y]) {
            parents[x] += parents[y];
            parents[y] = x;
        } else {
            parents[y] += parents[x];
            parents[x] = y;
        }

        return true;
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("Case #").append(tc).append(": ");

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parents = new int[N + 1];
            Arrays.fill(parents, -1);

            edges = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges.add(new int[]{from, to, weight});
            }

            res = 0;
            int cnt = 0;
            while (!edges.isEmpty()) {
                int[] edge = edges.poll();

                if (union(edge[0], edge[1])) {
                    cnt++;
                    res += edge[2];
                }

                if (cnt == N - 1) {
                    break;
                }
            }

            sb.append(res).append(" meters").append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
