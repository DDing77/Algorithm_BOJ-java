import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int INF = 222 * 2222;

    private int N;
    private int[][] board;
    private int[][] dp;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[0][i] = INF;
            dp[i][0] = INF;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                int left = dp[i][j - 1];
                if (board[i][j - 1] <= board[i][j]) {
                    left += board[i][j] - board[i][j - 1] + 1;
                }
                int top = dp[i - 1][j];
                if (board[i - 1][j] <= board[i][j]) {
                    top += board[i][j] - board[i - 1][j] + 1;
                }

                dp[i][j] = Math.min(left, top);
            }
        }

        System.out.println(dp[N][N]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
