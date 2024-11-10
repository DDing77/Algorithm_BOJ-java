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
    private int[] parents;
    private int[][] nodeInfo;
    private double res;

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

        if (x <= y) {
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

        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        nodeInfo = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            nodeInfo[i][0] = Integer.parseInt(st.nextToken());
            nodeInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.add(new Edge(i, j ,Math.sqrt(Math.pow((long)nodeInfo[i][0] - nodeInfo[j][0], 2) + Math.pow((long)nodeInfo[i][1] - nodeInfo[j][1], 2))));
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) ) {
                cnt++;
            }
        }

        while (!pq.isEmpty() && cnt < N - 1) {
            Edge cur = pq.poll();
            if (union(cur.node1, cur.node2)) {
                res += cur.distance;
                cnt++;
            }
        }

        System.out.println(String.format("%.2f", res));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {

        int node1;
        int node2;
        double distance;

        public Edge(int node1, int node2, double distance) {
            this.node1 = node1;
            this.node2 = node2;
            this.distance = distance;
        }


        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.distance, o.distance);
        }
    }
}
