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
    private int[] weights;
    private boolean[][] dp;

    private void makeTable(int depth, int sum) {
        dp[depth][sum] = true;

        if (depth == N) {
            return;
        }

        if (!dp[depth + 1][sum]) {
            makeTable(depth + 1, sum);
        }
        if (!dp[depth + 1][sum + weights[depth]]) {
            makeTable(depth + 1, sum + weights[depth]);
        }
        if (!dp[depth + 1][Math.abs(sum - weights[depth])]) {
            makeTable(depth + 1, Math.abs(sum - weights[depth]));
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][40_001];
        makeTable(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (dp[N][Integer.parseInt(st.nextToken())]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
