import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String A, B;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        dp = new int[A.length()+1][B.length()+1];

        for(int i=1; i<=A.length(); i++) {
            for(int j=1; j<=B.length(); j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else if(A.charAt(i-1) != B.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[A.length()][B.length()]);
//        for(int i=0; i<=A.length(); i++) System.out.println(Arrays.toString(dp[i]));
    }
}