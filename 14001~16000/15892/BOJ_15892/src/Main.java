import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Edge>[] graph;
    static int[] level;
    static int[] work;

    static void addEdge(int from, int to, int cap) {
        graph[from].add(new Edge(to, graph[to].size(), cap));
        graph[to].add(new Edge(from, graph[from].size() - 1, 0));
    }

    static boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        Queue<Integer> q = new ArrayDeque<>();
        level[s] = 0;
        q.add(s);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge e : graph[cur]) {
                if (e.capacity > 0 && level[e.to] == -1) {
                    level[e.to] = level[cur] + 1;
                    q.add(e.to);
                }
            }
        }
        return level[t] != -1;
    }

    static int dfs(int cur, int t, int flow) {
        if (cur == t) return flow;

        for (; work[cur] < graph[cur].size(); work[cur]++) {
            Edge e = graph[cur].get(work[cur]);
            if (e.capacity > 0 && level[e.to] == level[cur] + 1) {
                int minFlow = dfs(e.to, t, Math.min(flow, e.capacity));
                if (minFlow > 0) {
                    e.capacity -= minFlow;
                    graph[e.to].get(e.rev).capacity += minFlow;
                    return minFlow;
                }
            }
        }

        return 0;
    }

    static int dinic(int s, int t) {
        int maxFlow = 0;
        while (bfs(s, t)) {
            Arrays.fill(work, 0);
            int flow;
            while ((flow = dfs(s, t, Integer.MAX_VALUE)) > 0) {
                maxFlow += flow;
            }
        }
        return maxFlow;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        level = new int[n + 1];
        work = new int[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            addEdge(a, b, c);
            addEdge(b, a, c);
        }

        System.out.println(dinic(1, n));
    }

    static class Edge {
        int to, rev;
        int capacity;

        Edge(int to, int rev, int capacity) {
            this.to = to;
            this.rev = rev;
            this.capacity = capacity;
        }
    }
}
