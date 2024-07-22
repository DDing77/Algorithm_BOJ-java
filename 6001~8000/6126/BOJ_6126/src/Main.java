import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int V;
    private int[] coins;
    private long[][] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int length = 0;
        coins = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            if (coins[i] <= N) {
                length++;
            }
        }
        Arrays.sort(coins);

        dp = new long[V + 1][N + 1];
        for (int i = 1; i <= length; i++) {
            dp[i][coins[i]] = 1;
            for (int j = 1; j <= N; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] += dp[i][j - coins[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[length][N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
