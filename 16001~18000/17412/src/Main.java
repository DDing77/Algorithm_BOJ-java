import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, P;
    static int[][] capacity;
    static int[][] flow;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        capacity = new int[N + 1][N + 1];
        flow = new int[N + 1][N + 1];
        parent = new int[N + 1];
        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);

            capacity[start][end] = 1;
        }
        Queue<Integer> que;
        while (true) {
            que = new LinkedList<>();
            Arrays.fill(parent, -1);
            que.add(1);

            while (!que.isEmpty()) {
                int now = que.poll();
                for (int next : adj[now]) {
                    if (parent[next] == -1 && capacity[now][next] - flow[now][next] > 0) {
                        parent[next] = now;
                        if (next == 2) break;
                        que.add(next);
                    }
                }
            }

            if (parent[2] == -1) break;

            for (int i = 2; i != 1; i = parent[i]) {
                flow[parent[i]][i] += 1;
                flow[i][parent[i]] -= 1;
            }

            res += 1;
        }
        System.out.println(res);
    }
}
