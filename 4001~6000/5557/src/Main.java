import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N+1];
        dp = new long[N+1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp[1][arr[1]] = 1;

        for(int i= 2; i<=N-1; i++) {
            for(int j=0; j<=20; j++) {
                if(dp[i-1][j] != 0) {
                    if(arr[i] + j <=20) dp[i][j+arr[i]] += dp[i-1][j];
                    if(j- arr[i] >= 0) dp[i][j-arr[i]] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N-1][arr[N]]);
    }
}
