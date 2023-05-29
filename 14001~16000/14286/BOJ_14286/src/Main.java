import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Integer>[] edges;
    static int[] parent;
    static int[][] c;
    static int[][] f;
    static int res;

    static void maxFlowMinCut(int source, int sink) {
        res = 0;
        parent = new int[n + 1];

        while (true) {
            Arrays.fill(parent, -1);

            Queue<Integer> que = new LinkedList<>();
            que.add(source);
            parent[source] = source;

            while (!que.isEmpty() && parent[sink] == -1) {
                int cur = que.poll();
                for (int next : edges[cur]) {
                    if (c[cur][next] - f[cur][next] > 0 && parent[next] == -1) {
                        que.add(next);
                        parent[next] = cur;
                    }
                }
            }

            if (parent[sink] == -1) break;

            int min = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parent[i]) {
                min = Math.min(min, c[parent[i]][i] - f[parent[i]][i]);
            }

            for (int i = sink; i != source; i = parent[i]) {
                f[parent[i]][i] += min;
                f[i][parent[i]] -= min;
            }

            res += min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        c = new int[n + 1][n + 1];
        f = new int[n + 1][n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);

            c[a][b] = w;
            c[b][a] = w;
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        maxFlowMinCut(s, t);

        System.out.println(res);
    }
}
