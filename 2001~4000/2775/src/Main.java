import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T, k, n;
    static int[][] dp = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 14; i++) dp[0][i] = i;

        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        while (T-- > 0) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append('\n');
        }
        System.out.print(sb);
    }
}
