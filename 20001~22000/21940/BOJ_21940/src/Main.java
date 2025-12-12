import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int INF = 555555555;

    private int N;
    private int M;
    private int C;
    private int[][] dp;
    private int[] livingCites;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = c;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        C = Integer.parseInt(br.readLine());
        livingCites = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            livingCites[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> answerCities = new ArrayDeque<>();
        int resMin = INF;
        for (int i = 1; i <= N; i++) {
            int max = 0;

            for (int cityNum : livingCites) {
                max = Math.max(max, dp[i][cityNum] + dp[cityNum][i]);
            }

            if (max == INF) {
                continue;
            }

            if (max < resMin) {
                resMin = max;
                answerCities.clear();
                answerCities.add(i);
            } else if (max == resMin) {
                answerCities.add(i);
            }
        }

        for (Integer answerCity : answerCities) {
            sb.append(answerCity).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
