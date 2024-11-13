import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int M;
    private int K;
    private int[] friendsNode;
    private int[][] dp;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dp[i], 100001);
                dp[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dp[a][b] = c;
                dp[b][a] = c;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }

            K = Integer.parseInt(br.readLine());
            friendsNode = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                friendsNode[i] = Integer.parseInt(st.nextToken());
            }

            int minTotalDistance = Integer.MAX_VALUE;
            int resNodeNum = -1;
            for (int i = 1; i <= N; i++) {
                int sumDistance = 0;
                for (int j = 0; j < K; j++) {
                    sumDistance += dp[i][friendsNode[j]];
                }

                if (minTotalDistance > sumDistance) {
                    minTotalDistance = sumDistance;
                    resNodeNum = i;
                }
            }

            sb.append(resNodeNum).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
