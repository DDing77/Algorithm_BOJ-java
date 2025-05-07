import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, rev, cap;

        Edge(int to, int rev, int cap) {
            this.to = to;
            this.rev = rev;
            this.cap = cap;
        }
    }

    static List<Edge>[] graph;
    static int[] level, iter;
    static int N, S, T;

    static void addEdge(int from, int to, int cap) {
        graph[from].add(new Edge(to, graph[to].size(), cap));
        graph[to].add(new Edge(from, graph[from].size() - 1, 0));
    }

    static void bfs() {
        Arrays.fill(level, -1);
        Queue<Integer> q = new ArrayDeque<>();
        level[S] = 0;
        q.add(S);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (Edge e : graph[v]) {
                if (e.cap > 0 && level[e.to] < 0) {
                    level[e.to] = level[v] + 1;
                    q.add(e.to);
                }
            }
        }
    }

    static int dfs(int v, int t, int upTo) {
        if (v == t) return upTo;
        for (; iter[v] < graph[v].size(); iter[v]++) {
            Edge e = graph[v].get(iter[v]);
            if (e.cap > 0 && level[v] < level[e.to]) {
                int d = dfs(e.to, t, Math.min(upTo, e.cap));
                if (d > 0) {
                    e.cap -= d;
                    graph[e.to].get(e.rev).cap += d;
                    return d;
                }
            }
        }
        return 0;
    }

    static int maxFlow() {
        int flow = 0;
        while (true) {
            bfs();
            if (level[T] < 0) break;
            Arrays.fill(iter, 0);
            int f;
            while ((f = dfs(S, T, Integer.MAX_VALUE)) > 0) {
                flow += f;
            }
        }
        return flow;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = 0;
        T = 2 * N + 1;
        graph = new ArrayList[2 * N + 2];
        for (int i = 0; i <= 2 * N + 1; i++) graph[i] = new ArrayList<>();
        level = new int[2 * N + 2];
        iter = new int[2 * N + 2];

        int[] row = new int[N + 1], col = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            row[i] = Integer.parseInt(st.nextToken());
            addEdge(S, i, row[i]);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            col[i] = Integer.parseInt(st.nextToken());
            addEdge(i + N, T, col[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                addEdge(i, j + N, 1);
            }
        }

        int[][] res = new int[N + 1][N + 1];
        maxFlow();

        for (int i = 1; i <= N; i++) {
            for (Edge e : graph[i]) {
                if (1 <= e.to - N && e.to - N <= N && e.cap == 0) {
                    res[i][e.to - N] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int sum = Arrays.stream(res[i]).sum();
            if (sum != row[i]) {
                System.out.println(-1);
                return;
            }
        }

        for (int j = 1; j <= N; j++) {
            int sum = 0;
            for (int i = 1; i <= N; i++) sum += res[i][j];
            if (sum != col[j]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(1);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
