import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int Q;
    private int[] parents;
    private long resCost;
    private int resTime;

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
        Q = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost, time));
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);
        resCost = 0L;

        int cnt = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();

            if (union(edge.from, edge.to)) {
                cnt++;
                resCost += edge.cost;
                resTime = Math.max(resTime, edge.time);
            }

            if (cnt == N - 1) {
                break;
            }
        }

        if (cnt == N - 1) {
            System.out.println(resTime + " " + resCost);
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int from;
        int to;
        int cost;
        int time;

        public Edge(int from, int to, int cost, int time) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.cost == o.cost) {
                return Integer.compare(this.time, o.time);
            }
            return Integer.compare(this.cost, o.cost);
        }
    }
}
