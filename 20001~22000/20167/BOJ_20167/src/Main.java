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
    private int[] feeds;
    private int[] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        feeds = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            feeds[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int sum = feeds[i];
            int nextIdx = i + 1;
            dp[i] = Math.max(dp[i], dp[i - 1]);

            while (sum < K && nextIdx <= N) {
                sum += feeds[nextIdx];
                dp[nextIdx] = Math.max(dp[nextIdx], dp[nextIdx - 1]);
                nextIdx++;
            }

            dp[nextIdx - 1] = Math.max(dp[nextIdx - 1], dp[i - 1] + sum - K);
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}