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

    private int V;
    private int E;
    private PriorityQueue<Edge> pq;
    private int res;

    private int[] parents;

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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        parents = new int[V + 1];
        Arrays.fill(parents, -1);

        int cnt = 0;
        while (cnt < V - 1) {
            Edge cur = pq.poll();
            if (union(cur.from, cur.to)) {
                cnt++;
                res += cur.weight;
            }
        }

        System.out.println(res);
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
            return this.weight - o.weight;
        }
    }
}
