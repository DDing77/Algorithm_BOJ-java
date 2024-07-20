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
    private int[] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        Arrays.fill(dp, 100_000);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int caffeine = Integer.parseInt(st.nextToken());

            if (caffeine > K) {
                continue;
            }

            for (int j = K; j >= caffeine; j--) {
                dp[j] = Math.min(dp[j], dp[j - caffeine] + 1);
            }
        }

        if (dp[K] == 100_000) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[K]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
