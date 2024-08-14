import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MOD = 1_000_000_009;

    private int T;
    private int N;
    private int M;
    private int[][] dp;

    private void solution() throws IOException {

        dp = new int[1_001][1_001];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (j < k) {
                        break;
                    }
                    dp[j][i] += dp[j - k][i - 1];
                    dp[j][i] %= MOD;
                }
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(dp[N][M]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
