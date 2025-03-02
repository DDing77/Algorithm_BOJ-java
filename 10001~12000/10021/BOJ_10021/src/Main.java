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
    private int C;
    private Pos[] poses;
    private int[] parents;
    private long res;

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
        C = Integer.parseInt(st.nextToken());

        poses = new Pos[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            poses[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int weight = (int) Math.pow((poses[i].x - poses[j].x), 2) + (int) Math.pow((poses[i].y - poses[j].y), 2);
                if (weight >= C) {
                    pq.add(new Edge(i, j, weight));
                }
            }
        }

        parents = new int[N];
        Arrays.fill(parents, -1);

        res = 0L;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.weight < C) {
                continue;
            }

            if (union(edge.from, edge.to)) {
                res += edge.weight;
                cnt++;
            }

            if (cnt == N - 1) {
                System.out.println(res);
                return;
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Pos {

        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {

        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
