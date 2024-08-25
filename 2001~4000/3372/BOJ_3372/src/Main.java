import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private BigInteger[][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new BigInteger[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[1][1] = BigInteger.ONE;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (i == N && j == N) {
                    break;
                }

                int cur = Integer.parseInt(st.nextToken());
                if (cur == 0) {
                    continue;
                }

                if (i + cur <= N) {
                    dp[i + cur][j] = dp[i + cur][j].add(dp[i][j]);
                }
                if (j + cur <= N) {
                    dp[i][j + cur] = dp[i][j + cur].add(dp[i][j]);
                }
            }
        }

        System.out.println(dp[N][N].toString());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
