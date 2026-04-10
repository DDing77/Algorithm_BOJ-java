import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int n;
    private int m;
    private int k;

    private short[][] answer;
    private int[] parent;
    private ArrayList<Integer>[] groups;


    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y, int w) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        parent[x] = y;

        for (int a : groups[x]) {
            for (int b : groups[y]) {
                answer[a][b] = (short) w;
                answer[b][a] = (short) w;
            }
        }

        for (int a : groups[x]) {
            groups[y].add(a);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        answer = new short[n + 1][n + 1];
        parent = new int[n + 1];
        groups = new ArrayList[n + 1];

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            groups[i] = new ArrayList<>();
            groups[i].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, w));
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            union(edge.from, edge.to, edge.width);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(answer[a][b]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int width;

        Edge(int from, int to, int width) {
            this.from = from;
            this.to = to;
            this.width = width;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.width, this.width);
        }
    }
}