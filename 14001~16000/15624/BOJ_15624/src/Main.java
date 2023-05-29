import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        dp = new int[N + 1];

        dp[1] = 1;
        for (int i = 2; i <= N; i++) dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;

        System.out.println(dp[N]);
    }
}
