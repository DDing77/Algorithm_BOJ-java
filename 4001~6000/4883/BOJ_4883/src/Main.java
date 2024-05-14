import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] dp;

    private void solution() throws IOException {

        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            dp = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][2] += dp[0][1];
            dp[1][0] += dp[0][1];
            dp[1][1] += Math.min(dp[1][0], Math.min(dp[0][1], dp[0][2]));
            dp[1][2] += Math.min(dp[1][1], Math.min(dp[0][1], dp[0][2]));

            for (int i = 2; i < N; i++) {
                dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] += Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));
                dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
            }
            sb.append(tc++).append(". ").append(dp[N - 1][1]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
