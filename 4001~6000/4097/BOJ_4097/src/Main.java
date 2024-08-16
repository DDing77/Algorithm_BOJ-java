import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int P;
    private long[] dp;
    private long res;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            dp = new long[N + 1];
            dp[0] = -10_000L;
            res = dp[0];
            for (int i = 1; i <= N; i++) {
                int P = Integer.parseInt(br.readLine());
                dp[i] = Math.max(dp[i - 1] + P, P);
                res = Math.max(res, dp[i]);
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
