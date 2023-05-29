import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*author : DDing77*/

public class Main {

    private int N;
    private int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = cur;
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], cur - dp[i - 1][1]);
            dp[i][1] = Math.min(dp[i - 1][1], cur);
        }

        System.out.println(dp[N - 1][0]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
