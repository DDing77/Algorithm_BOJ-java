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
    private int[][] jumps;
    private int[][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        jumps = new int[N][2];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jumps[i][0] = Integer.parseInt(st.nextToken());
            jumps[i][1] = Integer.parseInt(st.nextToken());
        }

        if (N == 2) {
            System.out.println(jumps[1][0]);
            return;
        }

        K = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        for (int i = 2; i < dp.length; i++) {
            Arrays.fill(dp[i], 100_001);
        }
        dp[2][0] = jumps[1][0];
        dp[3][0] = Math.min(jumps[1][1], jumps[1][0] + jumps[2][0]);

        for (int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + jumps[i - 1][0], dp[i - 2][0] + jumps[i - 2][1]);
            dp[i][1] = dp[i - 3][0] + K;
            dp[i][1] = Math.min(dp[i][1], Math.min(dp[i - 1][1] + jumps[i - 1][0], dp[i - 2][1] + jumps[i - 2][1]));
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
