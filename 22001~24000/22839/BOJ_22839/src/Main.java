import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] dp;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            dp = new int[N + 1];
            dp[0] = 1;
            int coin = 1;
            while (coin * coin <= N) {
                for (int i = coin * coin; i <= N; i++) {
                    dp[i] += dp[i - coin * coin];
                }
                coin++;
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
