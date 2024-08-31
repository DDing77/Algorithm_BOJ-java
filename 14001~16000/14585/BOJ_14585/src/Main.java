import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int LENGTH = 301;

    private int N;
    private int M;
    private long[][] dp;
    private int[][] candies;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new long[LENGTH][LENGTH];
        candies = new int[LENGTH][LENGTH];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            candies[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = M;
        }

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                if (candies[i][j] != 0) {
                    dp[i][j] += Math.max(0, M -(i + j));
                }
            }
        }

        System.out.println(dp[LENGTH - 1][LENGTH - 1]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
