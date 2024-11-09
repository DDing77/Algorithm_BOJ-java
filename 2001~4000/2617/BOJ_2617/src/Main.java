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
    private int M;
    private int[][] dp;
    private int[] rows;
    private int[] cols;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 987654321);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        rows = new int[N + 1];
        cols = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && dp[i][j] != 987654321) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (rows[i] >= (N + 1) / 2) {
                res++;
            }
            if (cols[i] >= (N + 1) / 2) {
                res++;
            }
        }

        System.out.print(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
