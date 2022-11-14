import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] isVisited;
    static ArrayList<Integer>[] adj;
    static int[][] distance;
    static int res;

    // 1 -4 - 3
    //  - 2
    static void dfs(int from, int to, int sum) {
        if (from == to) {
            res = sum;
            return;
        }

        isVisited[from] = true;

        for (int next : adj[from]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            dfs(next, to, sum + distance[from][next]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);

            distance[from][to] = dist;
            distance[to][from] = dist;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            isVisited = new boolean[N + 1];
            res = 0;
            dfs(from, to, 0);
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}
