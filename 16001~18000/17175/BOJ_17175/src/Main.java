import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int MOD = 1_000_000_007;
    int N;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N < 2) {
            System.out.println(1);
            return;
        }

        dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] + 1) % MOD;
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
