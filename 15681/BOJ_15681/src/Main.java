import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, R, Q;
    static int[] dp;
    static ArrayList<Integer>[] adj;
    static boolean[] isVisited;

    static int dfs(int start) {
        if (dp[start] != 0) return dp[start];
        int cnt = 1;
        isVisited[start] = true;

        for (int next : adj[start]) {
            if (isVisited[next]) continue;
            cnt += dfs(next);
        }

        return dp[start] = cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        isVisited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        dp[R] = dfs(R);

        for (int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            sb.append(dp[node]).append('\n');
        }
        System.out.print(sb);
    }
}
