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
    private int V;
    private long[] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new long[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= V; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= N; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
