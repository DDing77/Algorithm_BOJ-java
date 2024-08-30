import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int H;
    private long[][] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + 1;
        H = Integer.parseInt(st.nextToken()) + 1;

        if (N > H) {
            int temp = N;
            N = H;
            H = temp;
        }

        dp = new long[H + 2][H + 2];
        dp[N][N] = 1L;
        for (int i = N; i <= H; i++) {
            for (int j = i; j <= H; j++) {
                if (i == N && j == N) {
                    continue;
                }

                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
            }
        }

        System.out.println(dp[H][H]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
