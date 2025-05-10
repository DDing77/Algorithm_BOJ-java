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
    private List<Edge>[] edges;
    private int[] depth;
    private int[] edgeIdxCount;
    private int res;

    private void addEdge(int from, int to, int cap) {
        edges[from].add(new Edge(to, cap, 0, edges[to].size()));
        edges[to].add(new Edge(from, 0, 0, edges[from].size() - 1));
    }

    private boolean bfs() {
        depth = new int[N + M + 2];
        Arrays.fill(depth, -1);
        depth[0] = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (Edge edge : edges[cur]) {
                if (depth[edge.to] == -1 && edge.cap - edge.flow > 0) {
                    depth[edge.to] = depth[cur] + 1;
                    que.add(edge.to);
                }
            }
        }

        return depth[M + N + 1] != -1;
    }

    private int dfs(int cur, int minFlow) {
        if (cur == N + M + 1) {
            return minFlow;
        }

        for (; edgeIdxCount[cur] < edges[cur].size(); edgeIdxCount[cur]++) {
            for (Edge edge : edges[cur]) {
                if (depth[edge.to] == depth[cur] + 1 && edge.cap - edge.flow > 0) {
                    int tempFlow = dfs(edge.to, Math.min(minFlow, edge.cap - edge.flow));

                    if (tempFlow > 0) {
                        edge.flow += tempFlow;
                        edges[edge.to].get(edge.rev).flow -= tempFlow;
                        return tempFlow;
                    }
                }
            }
        }

        return 0;
    }

    private void maxFlow() {
        res = 0;

        while (bfs()) {
            edgeIdxCount = new int[edges.length];

            int flow;
            while ((flow = dfs(0, Integer.MAX_VALUE)) > 0) {
                res += flow;
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new List[N + M + 2];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = M + 1; i <= M + N; i++) {
            int val = Integer.parseInt(st.nextToken());
            addEdge(i, M + N + 1, val);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int val = Integer.parseInt(st.nextToken());
            addEdge(0, i, val);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = M + 1; j <= M + N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) {
                    continue;
                }
                addEdge(i, j, val);
            }
        }

        maxFlow();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Edge {

        int to;
        int cap;
        int flow;
        int rev;

        public Edge(int to, int cap, int flow, int rev) {
            this.to = to;
            this.cap = cap;
            this.flow = flow;
            this.rev = rev;
        }
    }
}
