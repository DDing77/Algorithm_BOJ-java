import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, D;
    static final int source = 1, sink = 2, MAX = 305;
    static Queue<Integer> que;
    static ArrayList<Integer>[] adj;
    static int[][] capacity;
    static int[][] flow;
    static int[] parent;

    static int solution() {
        int sum = 0;
        while (true) {
            parent = new int[MAX];
            que = new LinkedList<>();
            que.add(source);
            parent[source] = source;

            while (!que.isEmpty() && parent[sink] == 0) {
                int now = que.poll();
                for (int next : adj[now]) {
                    if (capacity[now][next] - flow[now][next] > 0 && parent[next] == 0) {
                        que.add(next);
                        parent[next] = now;
                    }
                }
            }

            if (parent[sink] == 0) break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = sink; i != source; i = parent[i])
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            for (int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }
            sum += minFlow;
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[MAX];
        capacity = new int[MAX][MAX];
        flow = new int[MAX][MAX];

        for (int i = 0; i < MAX; i++) adj[i] = new ArrayList<>();

        for (int i = 3; i < N + 3; i++) {
            adj[source].add(i);
            adj[i].add(source);

            capacity[source][i] = K;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = N + 3; i < N + D + 3; i++) {
            adj[i].add(sink);
            adj[sink].add(i);

            capacity[i][sink] = Integer.parseInt(st.nextToken());
        }

        for (int i = 3; i < N + 3; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            for (int j = 0; j < length; j++) {
                int value = Integer.parseInt(st.nextToken());
                adj[i].add(N + 2 + value);
                adj[N + 2 + value].add(i);

                capacity[i][N + 2 + value] = 1;
            }
        }

        int res = solution();
        System.out.println(res);
    }
}
