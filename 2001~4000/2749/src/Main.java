import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());


        int mod = 1_000_000;
        int period = 15 * mod / 10;

        dp = new long[period + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= period; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        int index = (int) (n % period);

        System.out.println(dp[index]);
    }
}
