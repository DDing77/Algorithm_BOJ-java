import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int MOD = 1_000_000_009;

    private int N;
    private int[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        if (N < 3) {
            System.out.println(1);
        } else {
            dp = new int[N + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 3] + dp[i - 1]) % MOD;
            }
            System.out.println(dp[N]);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
