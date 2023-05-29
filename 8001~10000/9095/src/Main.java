import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<11; i++) dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        for(int t=0; t<T; t++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
