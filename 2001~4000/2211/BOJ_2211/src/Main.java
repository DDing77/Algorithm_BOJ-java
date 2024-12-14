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
    private ArrayList<Edge>[] edges;
    private int[] distances;
    private int[] parents;

    private void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distances[1] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (distances[cur.to] < cur.weight) {
                continue;
            }

            for (Edge next : edges[cur.to]) {
                if (distances[next.to] > distances[cur.to] + next.weight) {
                    distances[next.to] = distances[cur.to] + next.weight;
                    pq.add(new Edge(next.to, distances[next.to]));
                    parents[next.to] = cur.to;
                }
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        distances = new int[N + 1];
        parents = new int[N + 1];
        Arrays.fill(distances, 10_001);

        dijkstra(1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] != 0) {
                count++;
                sb.append(parents[i]).append(" ").append(i).append('\n');
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
