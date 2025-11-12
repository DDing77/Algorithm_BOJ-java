import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int INF = 1_000_001;

    private int N;
    private int K;
    private int[] dp;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int i = 0; i <= N; i++) {
            if (i + 1 <= N) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            if (i + i / 2 <= N) {
                dp[i + i / 2] = Math.min(dp[i + i / 2], dp[i] + 1);
            }
        }

        if (dp[N] <= K) {
            System.out.println("minigimbob");
        } else {
            System.out.println("water");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
