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
    private char[][] board;
    private int[][][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        dp = new int[N + 1][N + 1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j][0] = -123456789;
                dp[i][j][1] = 123456789;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j][0] = dp[i][j][1] = board[i][j] - '0';
                    continue;
                }

                if (board[i][j] == '+' || board[i][j] == '-' || board[i][j] == '*') {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                    continue;
                }

                int intVal = board[i][j] - '0';
                if (board[i][j - 1] == '+') {
                    dp[i][j][0] = intVal + dp[i][j - 1][0];
                    dp[i][j][1] = intVal + dp[i][j - 1][1];
                } else if (board[i][j - 1] == '-') {
                    dp[i][j][0] = dp[i][j - 1][0] - intVal;
                    dp[i][j][1] = dp[i][j - 1][1] - intVal;
                } else if (board[i][j - 1] == '*') {
                    dp[i][j][0] = intVal * dp[i][j - 1][0];
                    dp[i][j][1] = intVal * dp[i][j - 1][1];
                }

                if (board[i - 1][j] == '+') {
                    dp[i][j][0] = Math.max(dp[i][j][0], intVal + dp[i - 1][j][0]);
                    dp[i][j][1] = Math.min(dp[i][j][1], intVal + dp[i - 1][j][1]);
                } else if (board[i - 1][j] == '-') {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] - intVal);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][1] - intVal);
                } else if (board[i - 1][j] == '*') {
                    dp[i][j][0] = Math.max(dp[i][j][0], intVal * dp[i - 1][j][0]);
                    dp[i][j][1] = Math.min(dp[i][j][1], intVal * dp[i - 1][j][1]);
                }
            }
        }

        sb.append(dp[N][N][0]).append(" ").append(dp[N][N][1]);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
