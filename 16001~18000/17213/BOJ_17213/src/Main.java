import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int M;
    private int[][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N + 1][M + 1];
        Arrays.fill(dp[1], 1);

        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
        }

        System.out.println(dp[N][M]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
