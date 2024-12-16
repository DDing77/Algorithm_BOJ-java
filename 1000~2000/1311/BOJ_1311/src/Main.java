import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] costs;
    private int[][] dp;

    private int getDP(int cur, int status) {

        if (cur == N) {
            return 0;
        }

        if (dp[cur][status] != 0) {
            return dp[cur][status];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if ((status & (1 << i)) == 0) {
                res = Math.min(res, getDP(cur + 1, status | (1 << i)) + costs[cur][i]);
            }
        }

        return dp[cur][status] = res;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];
        System.out.println(getDP(0, 0));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
