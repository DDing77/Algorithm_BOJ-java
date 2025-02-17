import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int M;
    private static int p;
    private static int q;

    private int[] parents;
    private PriorityQueue<Edge> edges;

    private int find(int x) {
        if (parents[x] < 0) {
            return x;
        }
        return parents[x];
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

    private static boolean check(int x, int y) {
        if ((x == p && y == q) || (x == q && y == p)) {
            return true;
        }
        return false;
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            parents = new int[N + 1];
            Arrays.fill(parents, -1);

            edges = new PriorityQueue<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges.add(new Edge(from, to, weight));
            }

            int cnt = 0;
            boolean res = false;
            while (!edges.isEmpty()) {
                Edge edge = edges.poll();

                if (union(edge.from, edge.to)) {
                    cnt++;

                    if (check(edge.from, edge.to)) {
                        res = true;
                    }
                }

                if (cnt == N - 1) {
                    break;
                }
            }

            if (res) {
                sb.append("YES");
            } else {
                sb.append("NO");
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
            if (this.weight == o.weight) {
                if (check(this.weight, o.weight)) {
                    return -1;
                } else {
                    return 0;
                }
            }
            return Integer.compare(this.weight, o.weight);
        }
    }

}
