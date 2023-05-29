import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int[][][] dp;
    private char[][] map;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][N][N];
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        // 0 -> 가로
        // 1 -> 세로
        // 2 -> 대각선
        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (map[i][j] == '1') {
                    continue;
                }

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if (i == 0) continue;
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (map[i][j] == '0' && map[i - 1][j] == '0' && map[i][j - 1] == '0') {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        res = 0;
        for (int i = 0; i < 3; i++) {
            res += dp[N - 1][N - 1][i];
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
