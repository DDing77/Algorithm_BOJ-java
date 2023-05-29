import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_009;
    static int T;
    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            if (n <= 3) {
                sb.append(dp[n]).append('\n');
                continue;
            }

            for (int i = 4; i <= n; i++) dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD;

            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
