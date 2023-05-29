import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, K); j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        System.out.println(dp[N][K]);
    }
}
