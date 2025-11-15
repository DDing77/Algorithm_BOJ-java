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
    private int X;
    private int[] times;
    private ArrayList<Edge>[] edges;

    private void dijkstra() {
        Arrays.fill(times, 1000000001);
        times[X] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Info(X, 0));

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (times[info.cur] < info.weight) {
                continue;
            }

            for (Edge next : edges[info.cur]) {
                if (times[next.to] > times[info.cur] + next.time) {
                    times[next.to] = times[info.cur] + next.time;
                    pq.add(new Info(next.to, times[next.to]));
                }
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        times = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        dijkstra();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, times[i]);
        }
        System.out.println(max * 2);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge {
        int to;
        int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static class Info {
        int cur;
        int weight;

        public Info(int cur, int weight) {
            this.cur = cur;
            this.weight = weight;
        }
    }
}
