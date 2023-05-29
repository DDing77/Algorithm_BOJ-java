import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int[] dp;
    private int T, P;
    private int max;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        max = 0;
        res = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            max = Math.max(max, dp[i - 1]);

            if (i + T - 1 <= N) {
                dp[i + T - 1] = Math.max(dp[i + T - 1], max + P);
                res = Math.max(res, dp[i + T - 1]);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}