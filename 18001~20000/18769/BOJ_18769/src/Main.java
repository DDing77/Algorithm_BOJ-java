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

    private int T;
    private int R;
    private int C;
    private int[] parents;
    private PriorityQueue<Edge> pq;

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
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            parents = new int[R * C + 1];
            Arrays.fill(parents, -1);

            pq = new PriorityQueue<>();
            for (int i = 1; i <= R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < C; j++) {
                    int from = j + (C * (i - 1));
                    int to = from + 1;
                    int weight = Integer.parseInt(st.nextToken());
                    pq.add(new Edge(from, to, weight));
                }
            }

            for (int i = 1; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= C; j++) {
                    int from = j + (C * (i - 1));
                    int to = from + C;
                    int weight = Integer.parseInt(st.nextToken());
                    pq.add(new Edge(from, to, weight));
                }
            }

            int count = 0;
            int res = 0;
            while (count < (R * C) - 1) {
                Edge edge = pq.poll();
                if (union(edge.from, edge.to)) {
                    res += edge.weight;
                    count++;
                }
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
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
            return this.weight - o.weight;
        }
    }
}
