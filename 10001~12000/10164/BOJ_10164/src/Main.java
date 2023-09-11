import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int K;
    int[][] dp;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];

        boolean isCircle = false;
        int kX = 0;
        int kY = 0;
        dp[0][1] = 1;
        int cnt = 0;

        loop:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cnt++;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

                if (cnt == K) {
                    isCircle = true;
                    kX = i;
                    kY = j;
                    break loop;
                }
            }
        }

        if (isCircle) {
            for (int i = kX; i <= N; i++) {
                for (int j = kY; j <= M; j++) {
                    if ((i - 1) >= kX) dp[i][j] += dp[i - 1][j];
                    if ((j - 1) >= kY) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[N][M]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
