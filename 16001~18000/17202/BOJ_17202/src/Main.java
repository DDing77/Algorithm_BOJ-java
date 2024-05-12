import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String A;
    private String B;
    private int[] dp;

    private void solution() throws IOException {

        A = br.readLine();
        B = br.readLine();
        dp = new int[A.length() + B.length()];
        int idx = 0;
        for (int i = 0; i < A.length(); i++) {
            dp[idx] = A.charAt(i) - '0';
            dp[idx + 1] = B.charAt(i) - '0';
            idx += 2;
        }

        for (int k = 14; k >= 1; k--) {
            for (int i = 0; i <= k; i++) {
                dp[i] = (dp[i] + dp[i + 1]) % 10;
            }

        }
        System.out.println(dp[0] + "" + dp[1]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
