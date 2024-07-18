import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[][] chapters;
    private int[][] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chapters = new int[M + 1][2];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            chapters[i][0] = Integer.parseInt(st.nextToken());
            chapters[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (j - chapters[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - chapters[i][0]] + chapters[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[M][N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
