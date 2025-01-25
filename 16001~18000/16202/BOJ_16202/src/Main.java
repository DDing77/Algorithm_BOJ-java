import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private ArrayList<Edge> edges;
    private int[] parents;
    private int[] res;

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
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = i + 1;

            edges.add(new Edge(from, to, weight));
        }

        res = new int[K];
        int resIdx = 0;
        while (resIdx < K && !edges.isEmpty() && edges.size() >= N - 1) {
            int sum = 0;
            int cnt = 0;

            PriorityQueue<Edge> copyEdges = new PriorityQueue<>(edges);
            boolean isMst = false;
            boolean isDelete = false;

            parents = new int[N + 1];
            Arrays.fill(parents, -1);

            while (!copyEdges.isEmpty()) {
                Edge edge = copyEdges.poll();

                if (union(edge.from, edge.to)) {
                    sum += edge.weight;
                    cnt++;
                    if (!isDelete) {
                        edges.remove(edge);
                        isDelete = true;
                    }
                }

                if (cnt == N - 1) {
                    isMst = true;
                    break;
                }
            }

            if (isMst) {
                res[resIdx++] = sum;
            } else {
                break;
            }
        }

        for (int val : res) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int from;
        int to;
        int weight;
        boolean isUsed;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.isUsed = false;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
