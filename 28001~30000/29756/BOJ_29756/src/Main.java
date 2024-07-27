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
    private int K;
    private int[] scores;
    private int[] tired;
    private int[][] dp;

    private int getDp(int depth, int curHp) {

        if (depth == 0) {
            return 0;
        }

        int nextHp = Math.min(100, curHp + K);

        if (dp[depth][nextHp] != 0) {
            return dp[depth][nextHp];
        }

        int value = getDp(depth - 1, nextHp);
        if (nextHp - tired[depth] >= 0) {
            value = Math.max(value, getDp(depth - 1, nextHp - tired[depth]) + scores[depth]);
        }

        return dp[depth][nextHp] = value;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        scores = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        tired = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tired[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][101];

        System.out.println(getDp(N, 100));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
