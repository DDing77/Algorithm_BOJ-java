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
    private int resCost;
    private int resConnCnt;

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

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, weight));
        }

        List<Edge> usedEdges = new ArrayList<>();
        PriorityQueue<Edge> copyEdges = new PriorityQueue<>(edges);
        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        int cnt = 0;
        int originCost = 0;
        while (!copyEdges.isEmpty()) {
            Edge edge = copyEdges.poll();

            if (union(edge.from, edge.to)) {
                cnt++;
                originCost += edge.weight;
                usedEdges.add(edge);
            }

            if (cnt == N - 1) {
                break;
            }
        }

        for (Edge usedEdge : usedEdges) {
            copyEdges = new PriorityQueue<>(edges);
            copyEdges.remove(usedEdge);
            parents = new int[N + 1];
            Arrays.fill(parents, -1);

            cnt = 0;
            int cost = 0;
            while (!copyEdges.isEmpty()) {
                Edge edge = copyEdges.poll();

                if (union(edge.from, edge.to)) {
                    cnt++;
                    cost += edge.weight;
                }

                if (cnt == N - 1) {
                    break;
                }
            }

            if (cnt != N - 1 || cost != originCost) {
                resCost += usedEdge.weight;
                resConnCnt++;
            }
        }

        System.out.println(resConnCnt + " " + resCost);
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
