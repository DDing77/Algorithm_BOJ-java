import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long res;
    static long[][] dp;
    static final long MOD = 1_000_000_000;

    static long DP(int digit, int value) {
        if (digit == 1) return dp[digit][value];

        if (dp[digit][value] == 0) {
            if (value == 0) dp[digit][value] = DP(digit - 1, 1);
            else if (value == 9) dp[digit][value] = DP(digit - 1, 8);
            else dp[digit][value] = DP(digit - 1, value + 1) + DP(digit - 1, value - 1);
        }

        return dp[digit][value] % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        Arrays.fill(dp[1], 1L);
        res = 0;


        for (int i = 1; i < 10; i++) res += DP(N, i);
        System.out.println(res % MOD);
    }
}
