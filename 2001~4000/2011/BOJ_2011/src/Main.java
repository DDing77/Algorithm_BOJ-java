import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1000000;
    static String input;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        dp = new int[input.length() + 1];
        dp[0] = 1;

        for (int i = 1; i <= input.length(); i++) {
            int cur = input.charAt(i - 1) - '0';

            if (cur >= 1 && cur <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            if (i == 1) continue;

            int pre = input.charAt(i - 2) - '0';

            if (pre == 0) continue;

            int ten = pre * 10 + cur;

            if (ten >= 10 && ten <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[input.length()]);
    }
}