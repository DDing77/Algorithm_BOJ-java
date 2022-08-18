import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class DP {
        int left;
        int right;

        public DP(){
            this.left = 0;
            this.right = 0;
        }
    }
    static DP[] dp;

    static int n;
    static int[] reliability;
    static int[] protocol;
    static int[] host;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        reliability = new int[n+1];
        protocol = new int[n+1];
        host = new int[n+1];
        dp = new DP[n+1];
        for(int i=0; i<=n; i++) dp[i] = new DP();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) reliability[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++) {
            host[i] = Integer.parseInt(st.nextToken());
            protocol[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) dp[i].left = reliability[i];
        for(int i = n-1; i>0; i--) {
            if(protocol[i] == 1) {
                dp[host[i]].left = Math.max(dp[host[i]].left + Math.max(dp[i].left, dp[i].right) , dp[host[i]].right + dp[i].left);
                dp[host[i]].right += dp[i].right;
            } else if (protocol[i] == 0) {
                dp[host[i]].left += dp[i].right;
                dp[host[i]].right += Math.max(dp[i].left, dp[i].right);
            } else {
                dp[host[i]].left = Math.max(dp[host[i]].left + dp[i].right, dp[host[i]].right + dp[i].left);
                dp[host[i]].right += dp[i].right;
            }
        }

        res = Math.max(dp[0].left, dp[0].right);

        System.out.println(res);
    }
}
