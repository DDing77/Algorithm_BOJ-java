import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dp;
    static int[] mem, cost;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mem = new int[N+1];
        cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int sum =0;
        for(int i=1; i<=N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }
        dp = new int[N+1][ sum + 1];
        for( int i = 1; i<=N; i++) {
            for(int j = 0; j<=sum; j++) {
                if( j - cost[i] >= 0) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + mem[i]);
                else dp[i][j] = dp[i-1][j];
                if(dp[i][j]>=M) ans = Math.min(ans, j);
            }
        }
        System.out.println(ans);
    }
}
