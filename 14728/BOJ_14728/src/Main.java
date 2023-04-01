import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N, T;
    private int K, S;
    private int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= T; j++) {
                if (j < K) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - K] + S, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[N][T]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
