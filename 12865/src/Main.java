import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] vi, wi;
    static int N, W;
    static int[][] dp;

    static void getDp() {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=W; j++) {
                if(wi[i]>j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wi[i]] + vi[i]);
                }
            }
        }
        System.out.println(dp[N][W]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        vi = new int[N+1];
        wi = new int[N+1];
        dp = new int[N+1][W+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            wi[i] = Integer.parseInt(st.nextToken());
            vi[i] = Integer.parseInt(st.nextToken());
        }
        getDp();
    }
}
