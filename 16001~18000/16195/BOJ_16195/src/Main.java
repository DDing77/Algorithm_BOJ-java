import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int LENGTH = 1_001;
    private static final int MOD = 1_000_000_009;

    private int[][] dp;

    private int T;
    private int N;
    private int M;

    private void createDpTable() {

        dp = new int[LENGTH][LENGTH];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int k = 1; k <= 3; k++) {
                    if (i - k < 0) {
                        break;
                    }
                    dp[i][j] += dp[i - k][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }
    }

    private int getResult(int N, int M) {

        int res = 0;
        for (int i = 1; i <= M; i++) {
            res += dp[N][i];
            res %= MOD;
        }

        return res;
    }

    private void solution() throws IOException {

        createDpTable();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(getResult(N, M)).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
