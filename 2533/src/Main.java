import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] edges;
    static int[][] dp;
    static void dp(int cur, int parent) {
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        for(int next : edges[cur]) {
            if(next != parent) {
                dp(next, cur);
                dp[cur][0] += dp[next][1];
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        edges = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edges[start].add(end);
            edges[end].add(start);
        }
        dp(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
