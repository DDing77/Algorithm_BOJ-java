import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] stairs;
    private int[] dp;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        stairs = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        dp[0] = 1;
        res = dp[0];
        for (int i = 1; i < N; i++) {
            if (dp[i - 1] < stairs[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1], stairs[i]);
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
