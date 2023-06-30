import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_007;
    static int N;
    static long[][] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[1000_001][2];

        dp[1][0] = 2;
        dp[2][0] = 7;
        dp[2][1] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i][1] = (dp[i - 3][0] + dp[i - 1][1]) % MOD;
            dp[i][0] = (dp[i - 1][0] * 2 + dp[i - 2][0] * 3 + dp[i][1] * 2) % MOD;
        }

        System.out.println(dp[N][0] % MOD);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
