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

    private int[] parents;
    private PriorityQueue<int[]> edges;
    private ArrayList<int[]> resPath;
    private int resCost;

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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (union(from, to)) {
                cnt++;
            }
        }
        
        edges = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int cost;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                cost = Integer.parseInt(st.nextToken());
                if (i == 1 || j == 1) {
                    continue;
                }

                if (j >= i) {
                    continue;
                }

                edges.add(new int[]{i, j, cost});
            }
        }

        resPath = new ArrayList<>();
        while (!edges.isEmpty() && cnt < N - 2) {
            int[] edge = edges.poll();

            if (union(edge[0], edge[1])) {
                resPath.add(edge);
                resCost += edge[2];
                cnt++;
            }
        }

        sb.append(resCost).append(" ").append(resPath.size()).append("\n");
        for (int[] path : resPath) {
            sb.append(path[0]).append(" ").append(path[1]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
