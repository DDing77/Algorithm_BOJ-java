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
    private int K;
    private int[][] dp;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N - 1; i++) {
            int value = Integer.parseInt(st.nextToken());

            if (value > K) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }

            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
