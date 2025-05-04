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
    private long K;
    private List<Edge> edges;
    private long[] nodes;
    private long res;

    private void update(int start, int end, int targetIdx, int nodeNum) {
        if (targetIdx < start || end < targetIdx) {
            return;
        }

        if (start == end) {
            nodes[nodeNum]++;
            return;
        }

        int mid = (start + end) >> 1;
        update(start, mid, targetIdx, nodeNum << 1);
        update(mid + 1, end, targetIdx, nodeNum << 1 | 1);
        nodes[nodeNum] = nodes[nodeNum << 1] + nodes[nodeNum << 1 | 1];
    }

    private long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || end < queryLeft) {
            return 0L;
        }

        if (queryLeft <= start && end <= queryRight) {
            return nodes[nodeNum];
        }

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum << 1)
                + query(mid + 1, end, queryLeft, queryRight, nodeNum << 1 | 1);
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        int tc = 0;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b));
            }

            Collections.sort(edges);
            res = 0L;
            nodes = new long[M * 4];
            for (Edge edge : edges) {
                res += query(1, M, edge.b + 1, M, 1);
                update(1, M, edge.b, 1);
            }
            sb.append("Test case ").append(++tc).append(": ").append(res).append("\n");
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

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.a == o.a) {
                return Integer.compare(this.b, o.b);
            }
            return Integer.compare(this.a, o.a);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
