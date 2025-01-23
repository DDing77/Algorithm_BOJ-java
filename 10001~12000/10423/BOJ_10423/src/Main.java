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
    private int M;
    private int K;

    private int[] parents;
    private boolean[] flag;
    private int aliveCnt;
    private int resValue;
    private PriorityQueue<Edge> edges;

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

        if (flag[x] != flag[y]) {
            if (flag[x]) {
                parents[x] += parents[y];
                aliveCnt += parents[y] * -1;
                parents[y] = x;
            } else {
                parents[y] += parents[x];
                aliveCnt += parents[x] * -1;
                parents[x] = y;
            }
        } else if (!flag[x] && !flag[y]) {
            if (parents[x] <= parents[y]) {
                parents[x] += parents[y];
                parents[y] = x;
            } else {
                parents[y] += parents[x];
                parents[x] = y;
            }
        } else if (flag[x] && flag[y]) {
            return false;
        }
        return true;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        flag = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            flag[Integer.parseInt(st.nextToken())] = true;
        }

        edges = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        aliveCnt = K;
        while (!edges.isEmpty() && aliveCnt < N) {
            Edge edge = edges.poll();

            if (union(edge.from, edge.to)) {
                resValue += edge.weight;
            }
        }

        System.out.println(resValue);
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
            return Integer.compare(this.weight, o.weight);
        }
    }
}
