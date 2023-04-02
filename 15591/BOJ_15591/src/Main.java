import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private int N, Q;
    private ArrayList<Edge>[] adj;
    private boolean[] isVisited;

    public int bfs(int k, int start) {
        isVisited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        isVisited[start] = true;

        int res = 0;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Edge next : adj[cur]) {
                if (!isVisited[next.to] && next.weight >= k) {
                    res++;
                    que.add(next.to);
                    isVisited[next.to] = true;
                }
            }
        }
        return res;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adj[p].add(new Edge(q, r));
            adj[q].add(new Edge(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(k, v)).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
