import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] energy;
    static int[] happy;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        energy = new int[n + 1];
        happy = new int[n + 1];
        dp = new int[n + 1][101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) energy[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) happy[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (j - energy[i] > 0) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-energy[i]] + happy[i]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n][100]);
    }
}
