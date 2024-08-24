import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MOD = 1_000_007;

    private int w;
    private int h;
    private int x;
    private int y;
    private long[][] dp;
    private long res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dp = new long[h][w];
        for (int i = 0; i < h; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < w; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        res = dp[y - 1][x - 1];
        res *= dp[h - y][w - x];
        res %= MOD;

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
