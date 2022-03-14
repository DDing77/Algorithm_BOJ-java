import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static int N;
    static int[] town;
    static int[][] dp;
    static ArrayList<Integer>[] adj;

    static void DFS(int cur, int parent) {
        for (int child : adj[cur]) {
            if (child != parent) {
                DFS(child, cur);
                dp[cur][0] += Math.max(dp[child][0], dp[child][1]);
                dp[cur][1] += dp[child][0];
            }
        }
        dp[cur][1] += town[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        town = new int[N + 1];
        dp = new int[N + 1][2];
        adj = new ArrayList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) town[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            adj[end].add(start);
        }
        DFS(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
