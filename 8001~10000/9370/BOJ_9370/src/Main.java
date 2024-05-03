import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int INF = Integer.MAX_VALUE;
    private int T;
    private int N;
    private int M;
    private int t;
    private int s;
    private int g;
    private int h;
    private ArrayList<Edge>[] edges;
    private int[] dist;
    private int[] destination;

    private void dijkstra() {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[s] = 0;
        pq.add(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (Edge next : edges[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.weight) {
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if ((from == g && to == h) || (from == h && to == g)) {
                    edges[from].add(new Edge(to, weight * 2 - 1));
                    edges[to].add(new Edge(from, weight * 2 - 1));
                } else {
                    edges[from].add(new Edge(to, weight * 2));
                    edges[to].add(new Edge(from, weight * 2));
                }
            }

            destination = new int[t];
            for (int i = 0; i < t; i++) {
                destination[i] = Integer.parseInt(br.readLine());
            }

            dijkstra();

            Arrays.sort(destination);
            for (int i : destination) {
                if (dist[i] % 2 == 1 && dist[i] != INF) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }
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
