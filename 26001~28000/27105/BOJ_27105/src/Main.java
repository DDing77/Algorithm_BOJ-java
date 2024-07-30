import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private long[][] dp;

    private long getDp(int remainder, int cur) {

        if (remainder < 0 || cur < 0) {
            return 0;
        }

        if (dp[remainder][cur] != -1) {
            return dp[remainder][cur];
        }

        if (remainder == 0 && cur == 0) {
            return 1;
        }

        return dp[remainder][cur] = getDp(remainder - cur, cur - 1) + getDp(remainder, cur - 1);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        int length = N * (N + 1) / 2;

        if (length % 2 == 1) {
            System.out.println(0);
        } else {
            dp = new long[length /2 + 1][N + 1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            System.out.println(getDp(length / 2, N) / 2);
        }


    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
