import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                if(j<arr[i]) dp[i][j] = dp[i-1][j];
                else if(j == arr[i]) dp[i][j] = dp[i-1][j] + 1;
                else dp[i][j] = dp[i][j-arr[i]] + dp[i-1][j];
            }
        }
//        for(int i=0 ;i<=n; i++) System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[n][k]);
    }
}
