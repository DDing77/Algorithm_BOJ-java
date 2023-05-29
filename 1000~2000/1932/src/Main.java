import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        dp = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j= 1; j<=i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i= 1; i<=N; i++) {
            for(int j =1; j<=i; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
//        for(int i=1; i<=N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            ans = Math.max(ans, dp[N][i]);
        }
        System.out.println(ans);
    }
}
