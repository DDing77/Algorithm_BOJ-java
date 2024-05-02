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
        if (N <= 3) {
            System.out.println(N);
            return;
        }

        dp = new long[N + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = (long) i;
        }

        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10;
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
