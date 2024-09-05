import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MOD = 1_000_000_007;

    private int N;
    private int[][] dp;

    private int getDp(int i, int j) {

        if (i == 0 || j == 0) {
            return 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        return dp[i][j] = (getDp(i - 1, j) % MOD + getDp(i, j - 1) % MOD) % MOD;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
        }

        dp = new int[N + 1][N + 1];

        getDp(N, N);

        sb.append(dp[N][N]).append(" ").append(N * N);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}