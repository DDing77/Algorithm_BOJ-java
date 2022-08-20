import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int to;
        int from;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public Edge(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] edges;
    static ArrayList<Edge> edge;

    static class Info {
        int n;
        int pre;
        int depth;
        int cost;

        public Info(int n, int cost, int pre, int depth) {
            this.n = n;
            this.cost = cost;
            this.pre = pre;
            this.depth = depth;
        }
    }

    static int N, M;
    static int LogN;
    static int[][] parent;
    static boolean[] isVisited;
    static int[][] dist;
    static int[] depth;

    static void getLogN() {
        LogN = 0;
        for (int k = 1; k < N; k *= 2) LogN++;
    }

    static void makeSpareTable() {
        for (int i = 1; i <= LogN; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                dist[i][j] = Math.max(dist[i - 1][j], dist[i - 1][parent[i - 1][j]]);
            }
        }
    }

    static int getLca(int x, int y) {
        if (depth[y] > depth[x]) return getLca(y, x);
        for (int i = 0; i <= LogN; i++) {
            if (((depth[x] - depth[y]) & (1 << i)) >= 1) {
                x = parent[i][x];
            }
        }

        if (x == y) return x;

        for (int i = LogN; i >= 0; i--) {
            if (parent[i][x] != parent[i][y]) {
                x = parent[i][x];
                y = parent[i][y];
            }
        }
        return parent[0][x];
    }

    static long getMst() {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Info(1, 0, 1, 0));

        long res = 0;
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (isVisited[cur.n]) continue;
            isVisited[cur.n] = true;

            parent[0][cur.n] = cur.pre;
            dist[0][cur.n] = cur.cost;
            depth[cur.n] = cur.depth;
            res += cur.cost;
            for (int i = 0; i < edges[cur.n].size(); i++) {
                if (!isVisited[edges[cur.n].get(i).to]) {
                    pq.add(new Info(edges[cur.n].get(i).to, edges[cur.n].get(i).weight, cur.n, cur.depth + 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        getLogN();

        parent = new int[LogN + 1][N + 1];
        dist = new int[LogN + 1][N + 1];
        isVisited = new boolean[N + 1];
        depth = new int[N + 1];
        edge = new ArrayList<>();

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) edges[i] = new ArrayList<>();


        int from, to, weight;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
            edge.add(new Edge(from, to, weight));
        }

        long min = getMst();
        makeSpareTable();

        for (Edge edge : edge) {
            int f = edge.from;
            int t = edge.to;
            int w = edge.weight;
            long res = min + w;
            int lca = getLca(f, t);
            int fLca = depth[f] - depth[lca];
            int tLca = depth[t] - depth[lca];
            int max = -1;

            for (int i = LogN; i >= 0; i--) {
                if (fLca >= (1 << i)) {
                    max = Math.max(max, dist[i][f]);
                    fLca -= (1 << i);
                    f = parent[i][f];
                }
            }

            for (int i = LogN; i >= 0; i--) {
                if (tLca >= (1 << i)) {
                    max = Math.max(max, dist[i][t]);
                    tLca -= (1 << i);
                    t = parent[i][t];
                }
            }
            sb.append(res - max).append('\n');
        }
        System.out.print(sb);
    }
}