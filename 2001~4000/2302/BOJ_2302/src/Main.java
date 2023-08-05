import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int M;
    int[] dp;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;
        if (N >= 2) {
            dp[2] = 2;
        }

        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        int pre = 0;
        res = 1;

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            int cur = Integer.parseInt(br.readLine());
            res *= dp[cur - pre - 1];
            pre = cur;
        }

        res *= dp[N - pre];

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
