import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            map = new int[2][n + 1];
            dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
            }

            int res = Math.max(dp[0][n], dp[1][n]);
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
