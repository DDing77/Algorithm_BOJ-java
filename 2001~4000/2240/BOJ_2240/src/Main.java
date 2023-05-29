import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T, W;
    private int[][] dp;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        res = 0;
        dp = new int[T + 1][W + 1];
        for (int i = 1; i <= T; i++) {
            int cur = Integer.parseInt(br.readLine());

            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    if (cur == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    res = Math.max(res, dp[i][j]);
                    continue;
                }

                if (j % 2 == 1) {
                    if (cur == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    }
                } else {
                    if (cur == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
