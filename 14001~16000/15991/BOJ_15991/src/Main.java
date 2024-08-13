import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int LENGTH = 50_001;
    private static final int MOD = 1_000_000_009;
    private static final int RANGE = 3;

    private int T;
    private int N;
    private int[] dp;
    private int res;

    private void solution() throws IOException {

        dp = new int[LENGTH];

        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= RANGE; j++) {
                if (j > i) {
                    break;
                }
                dp[i] += dp[i - j];
                dp[i] %= MOD;
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            res = 0;

            for (int i = 0; i <= RANGE; i++) {
                if (N >= i && (N - i) % 2 == 0) {
                    res += dp[(N - i) / 2];
                    res %= MOD;
                }
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
