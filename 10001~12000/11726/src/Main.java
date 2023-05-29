import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n+2];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }
        System.out.println(dp[n]%10007);
    }
}
// 1 2 3 4 5 6 7 8 9
// 1 2 3 5 8 13 21 34 55

