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
    private PriorityQueue<Edge> pq = new PriorityQueue<>();
    private int[] ranks;

    private int find(int x) {
        if (ranks[x] < 0) {
            return x;
        }
        return ranks[x] = find(ranks[x]);
    }

    private boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
             return false;
        }

        if (ranks[px] < ranks[py]) {
            ranks[px] += ranks[py];
            ranks[py] = px;
        } else {
            ranks[py] += ranks[px];
            ranks[px] = py;
        }

        return true;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()))
            );
        }

        ranks = new int[N + 1];
        Arrays.fill(ranks, -1);

        int curT = 0;
        int cnt = 0;
        while (!pq.isEmpty() && cnt < N - 1) {
            Edge edge = pq.poll();
            if (edge.t != curT + 1) {
                break;
            }

            if (union(edge.from, edge.to)) {
                curT++;
            }
        }

        System.out.println(curT + 1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int t;

        public Edge(int from, int to, int t) {
            this.from = from;
            this.to = to;
            this.t = t;
        }

        @Override
        public int compareTo(Edge o) {
            return this.t - o.t;
        }
    }
}
