import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int MOD = 1_000_000_007;
    private int N;
    private int M;
    private int[][] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1 | j == 1) {
                    dp[i][j] = 1;
                }
                dp[i][j] = ((dp[i][j - 1] + dp[i - 1][j - 1]) % MOD + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[N][M]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
