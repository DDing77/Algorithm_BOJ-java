import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 987654321;
    private int T;
    private int E;
    private int F;
    private int N;
    private int P;
    private int W;
    private int[][] dp;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            E = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken()) - E;
            N = Integer.parseInt(br.readLine());

            if (E == F) {
                sb.append("The minimum amount of money in the piggy-bank is ").append(0).append('\n');
                continue;
            }

            dp = new int[N + 1][F + 1];
            for (int i = 0; i <= N; i++) {
                for (int j = 1; j <= F; j++) {
                    dp[i][j] = MAX;
                }
            }
            dp[0][0] = 0;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                P = Integer.parseInt(st.nextToken());
                W = Integer.parseInt(st.nextToken());

                for (int j = 1; j <= F; j++) {
                    if (j - W >= 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - W] + P, dp[i - 1][j - W] + P));
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            if (dp[N][F] == MAX) {
                sb.append("This is impossible.").append('\n');
            } else {
                sb.append("The minimum amount of money in the piggy-bank is ").append(dp[N][F]).append('.').append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
