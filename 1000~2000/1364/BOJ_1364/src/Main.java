import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private long[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        if (N < 6) {
            System.out.println(N);
            return;
        }

        dp = new long[N + 1];
        long plus = 1L;
        for (int i = 1; i <= 5; i++) {
            dp[i] = dp[i - 1] + plus;
        }

        for (int i = 6; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = dp[i - 1] + (plus + 1);
            } else if (i % 6 == 1) {
                dp[i] = dp[i - 1] + plus;
            } else if (i % 6 == 2) {
                plus++;
                dp[i] = dp[i - 1] + plus;
            } else {
                dp[i] = dp[i - 1] + plus;
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
