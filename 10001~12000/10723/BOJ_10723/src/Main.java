import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int M;
    private ArrayList<Edge> edges = new ArrayList<>();
    private int[] parents;
    private long res = 0L;

    private void init() {
        parents = new int[N];
        Arrays.fill(parents, -1);
    }

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

        if (parents[x] < parents[y]) {
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
        while (T-- > 0) {
            edges.clear();

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            res = 0;
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int to  = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(i, to, cost));
            }

            List<Long> resList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, cost));
                Collections.sort(edges);

                init();
                long total = 0L;
                int cnt = 0;
                for (int j = 0; j < edges.size(); j++) {
                    Edge edge = edges.get(j);
                    if (union(edge.a, edge.b)) {
                        total += edge.cost;
                        cnt++;
                    }

                    if (cnt == N - 1) {
                        break;
                    }
                }

                resList.add(total);
            }

            res = resList.get(0);
            for (int i = 1; i < resList.size(); i++) {
                res ^= resList.get(i);
            }
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
