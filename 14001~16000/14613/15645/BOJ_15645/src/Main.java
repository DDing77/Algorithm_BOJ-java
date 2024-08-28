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
    private int[][] board;
    private int[][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + board[i][0];
            dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + board[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + board[i][2];
        }

        int max = -1;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[N][i]);
        }

        dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + board[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + board[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + board[i][2];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N][i]);
        }

        sb.append(max).append(" ").append(min);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
