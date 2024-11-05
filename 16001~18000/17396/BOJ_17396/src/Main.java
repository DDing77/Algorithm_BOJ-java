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
    private boolean[] acceptable;
    private ArrayList<Edge>[] edges;
    private long[] distances;

    private void dijkstra(int start, int dist) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        distances = new long[N];
        Arrays.fill(distances, Long.MAX_VALUE);
        distances[0] = 0L;

        boolean[] isVisited = new boolean[N];

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

//            if (distances[cur.to] < cur.weight) {
//                continue;
//            }

            if (isVisited[cur.to]) {
                continue;
            }
            isVisited[cur.to] = true;

            for (Edge next : edges[cur.to]) {
                if (next.to != N - 1 && !acceptable[next.to]) {
                    continue;
                }
                if (distances[next.to] > distances[cur.to] + next.weight) {
                    distances[next.to] = distances[cur.to] + next.weight;
                    pq.add(new Edge(next.to, distances[next.to]));
                }
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        acceptable = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val == 0) {
                acceptable[i] = true;
            }
        }

        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

//            if ((from != N - 1 && !acceptable[from]) || (to != N - 1 && !acceptable[from])) {
//                continue;
//            }

            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        dijkstra(0, 0);

        if (distances[N - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(distances[N - 1]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}
