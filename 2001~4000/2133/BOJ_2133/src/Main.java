import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if ((N & 1) == 1) {
            System.out.println(0);
            return;
        }

        dp = new int[N + 1];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
            dp[i] += dp[i - 2] * 3;
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
