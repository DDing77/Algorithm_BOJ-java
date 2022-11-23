import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static final long MOD = 1_000_000_007l;
    static int N, M;
    static boolean[] isVisited;
    static long[] weight;
    static ArrayList<Integer>[] adj;
    static long res;
    static Edge[] edges;

    static boolean dfs(int current) {
        if (current == N - 1) return true;
        isVisited[current] = true;

        for (int next : adj[current]) {
            if (!isVisited[next]) {
                if(dfs(next)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to);
        }

        weight = new long[M + 1];
        weight[0] = 1;
        for (int i = 1; i < M; i++) {
            weight[i] = weight[i - 1] * 3;
            weight[i] %= MOD;
        }

        res = 0;

        for (int i = M - 1; i >= 0; i--) {
            isVisited = new boolean[N];
            adj[edges[i].from].add(edges[i].to);
            adj[edges[i].to].add(edges[i].from);
            if (dfs(0)) {
                adj[edges[i].from].remove(adj[edges[i].from].size() - 1);
                adj[edges[i].to].remove(adj[edges[i].to].size() - 1);
                res += weight[i];
                res %= MOD;
            }
        }

        System.out.println(res);
    }
}
