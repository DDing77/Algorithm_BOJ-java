import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, m, n;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n  = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            dp = new long[n+1][m+1];
            for(int i=0; i<=m; i++) {
                dp[0][i] = 1;
            }

            for(int i=1; i<=n; i++) {
                for(int j=1; j<=m; j++) {
                    dp[i][j] = dp[i-1][j/2] + dp[i][j-1];
                }
            }
            sb.append(dp[n][m]).append('\n');
        }
        System.out.println(sb);
    }
}
