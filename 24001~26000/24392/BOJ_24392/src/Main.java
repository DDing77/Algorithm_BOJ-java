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
    private int M;
    private char[][] board;
    private int[][] dp;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        dp = new int[N + 1][M + 2];
        for (int i = 1; i <= M; i++) {
            dp[N][i] = board[N][i] - '0';
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] != '1') {
                    continue;
                }
                dp[i][j] = ((dp[i + 1][j - 1] + dp[i + 1][j]) % MOD + dp[i + 1][j + 1]) % MOD;
            }
        }

        for (int i = 1; i <= M; i++) {
            res = (res + dp[1][i]) % MOD;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
