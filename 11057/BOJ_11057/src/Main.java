import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] dp;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];

        Arrays.fill(dp[1], 1);

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= 9; j++) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
        }

        res = 0;
        for (int num : dp[N]) res += num;

        System.out.println(res % 10007);
    }
}
