import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int X, Y, M;
    private int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];
        dp[X] = X;
        for (int i = X + 1; i <= M; i++) {
            dp[i] = Math.max(dp[i - X] + X, dp[i]);
            if (i >= Y) {
                dp[i] = Math.max(dp[i - Y] + Y, dp[i]);
            }
        }
        System.out.println(dp[M]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
