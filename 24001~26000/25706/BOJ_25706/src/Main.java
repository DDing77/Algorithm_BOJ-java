import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] road;
    private int[] dp;

    private int getDp(int idx) {

        if (idx > N) {
            return 0;
        }

        if (dp[idx] != 0) {
            return dp[idx];
        }

        return dp[idx] = 1 + getDp(idx + 1 + road[idx]);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        road = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (dp[i] == 0) {
                getDp(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
