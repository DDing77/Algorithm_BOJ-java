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

    private int T;
    private int n;
    private int d;
    private int c;
    private ArrayList<Edge>[] edges;
    private int[] times;

    private void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        times[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (times[cur.to] < cur.second) {
                continue;
            }

            for (Edge next : edges[cur.to]) {
                if (times[next.to] > times[cur.to] + next.second) {
                    times[next.to] = times[cur.to] + next.second;
                    pq.add(new Edge(next.to, times[next.to]));
                }
            }
        }
    }

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edges[b].add(new Edge(a, s));
            }

            times = new int[n + 1];
            Arrays.fill(times, Integer.MAX_VALUE);
            dijkstra(c);

            int count = 0;
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (times[i] != Integer.MAX_VALUE) {
                    count++;
                    res = Math.max(res, times[i]);
                }
            }

            sb.append(count).append(" ").append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int to;
        int second;

        public Edge(int to, int second) {
            this.to = to;
            this.second = second;
        }

        @Override
        public int compareTo(Edge o) {
            return this.second - o.second;
        }
    }
}
