import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[] parents;
    private ArrayList<Edge> edges;

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

    private int getMst(int ascCnt, int type) {

        int res = ascCnt;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

            @Override
            public int compare(Edge o1, Edge o2) {

                if (type == 0) {
                    return Integer.compare(o2.weight, o1.weight);
                }
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        for (Edge edge : edges) {
            pq.add(edge);
        }

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        int cnnCnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (union(edge.from, edge.to)) {
                cnnCnt++;

                if (edge.weight == 0) {
                    res++;
                }

                if (cnnCnt == N - 1) {
                    break;
                }
            }
        }

        return res;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int type = Integer.parseInt(st.nextToken());

        int ascCnt = 0;
        if (type == 0) {
            ascCnt++;
        }

        edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int max = getMst(ascCnt, 0);
        int min = getMst(ascCnt, 1);
        System.out.println(Math.abs(max * max - min * min));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
