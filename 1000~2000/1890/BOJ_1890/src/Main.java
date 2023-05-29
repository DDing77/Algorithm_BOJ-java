import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private long[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][N + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int distance = Integer.parseInt(st.nextToken());

                if (distance > 0 && dp[i][j] != 0) {
                    if (distance + i <= N) {
                        dp[distance + i][j] += dp[i][j];
                    }

                    if (distance + j <= N) {
                        dp[i][distance + j] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[N][N]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

