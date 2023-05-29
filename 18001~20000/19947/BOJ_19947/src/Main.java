import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int H, Y;
    static int[] dp;

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dp = new int[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            if (i - 1 >= 0) {
                dp[i] = Math.max((int) (dp[i - 1] * 1.05), dp[i]);
            }

            if (i - 3 >= 0) {
                dp[i] = Math.max((int) (dp[i - 3] * 1.2), dp[i]);
            }

            if (i - 5 >= 0) {
                dp[i] = Math.max((int) (dp[i - 5] * 1.35), dp[i]);
            }
        }

        System.out.println(dp[Y]);
    }
}

