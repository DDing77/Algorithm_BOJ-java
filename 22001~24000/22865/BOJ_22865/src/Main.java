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
    private ArrayList<Edge>[] edges;
    private int A;
    private int B;
    private int C;
    private int[] distA;
    private int[] distB;
    private int[] distC;

    private int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 100_000_000);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.distance) {
                continue;
            }

            for (Edge next : edges[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.distance) {
                    dist[next.to] = dist[cur.to] + next.distance;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            edges[D].add(new Edge(E, L));
            edges[E].add(new Edge(D, L));
        }

        distA = dijkstra(A);
        distB = dijkstra(B);
        distC = dijkstra(C);

        int resIdx = 0;
        int minDist = 0;
        for (int i = 1; i <= N; i++) {
            int curMin = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if (curMin > minDist) {
                minDist = curMin;
                resIdx = i;
            }
        }

        System.out.println(resIdx);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge {
        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
