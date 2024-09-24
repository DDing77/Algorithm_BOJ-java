import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private long[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1L;
            if (i - 6 > 0) {
                for (int j = 2; j < 5; j++) {
                    dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
                }
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
