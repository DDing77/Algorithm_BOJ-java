import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int[] coin = {7, 5, 2, 1};

    private int N;
    private int[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        Arrays.fill(dp, 100_000);
        dp[0] = 0;

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
