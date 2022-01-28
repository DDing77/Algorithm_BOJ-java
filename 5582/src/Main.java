import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String A,B;
    static int[][] dp;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        dp = new int[A.length()+1][B.length()+1];
        for(int i = 1; i<=A.length(); i++) {
            for(int j=1; j<=B.length(); j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] +1 );
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans);
    }
}
