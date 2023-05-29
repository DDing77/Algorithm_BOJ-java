import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coin = new int[n + 1];
        dp = new int[k + 1];

        for (int i = 1; i <= n; i++) coin[i] = Integer.parseInt(br.readLine());

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
        }

        if (dp[k] == Integer.MAX_VALUE - 1) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}
