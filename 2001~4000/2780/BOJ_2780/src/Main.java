import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int MOD = 1_234_567;

    private int T;
    private int N;
    private int[][] dp;
    private int[][] dir = {{7}, {2, 4}, {1, 3, 5}, {2, 6}, {1, 5, 7}, {2, 4, 6, 8}, {3, 5, 9}, {0, 4, 8}, {5, 7, 9}, {6, 8}};
    private int res;

    private void solution() throws IOException {

        dp = new int[1_001][10];
        for (int i = 0; i < dp[i].length; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dir[j].length; k++) {
                    dp[i][j] += dp[i - 1][dir[j][k]];
                    dp[i][j] %= MOD;
                }
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            res = 0;

            for (int i = 0; i < dp[i].length; i++) {
                res += dp[N][i];
                res %= MOD;
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
