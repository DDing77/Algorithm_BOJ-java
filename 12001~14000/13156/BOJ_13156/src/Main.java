import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int c;
    private int m;
    private int[][] merchants;
    private int[][] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        merchants = new int[m + 1][c + 1];
        dp = new int[m + 1][c + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                merchants[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], merchants[i][j]);
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + merchants[i][j - k]);
                }
            }
        }

        System.out.println(dp[m][c]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
