import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int n;
    private int W;
    private int[][] dp;


    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dp = new int[n + 1][W + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                for (int j = 1; j <= W; j++) {
                    if (j - w >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            sb.append(dp[n][W]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
