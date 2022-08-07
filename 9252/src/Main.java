import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String A, B;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        A = br.readLine();
        B = br.readLine();

        dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[A.length()][B.length()]);

        int x = A.length();
        int y = B.length();
        while (x != 0 && y != 0) {
            if(dp[x][y] == dp[x-1][y]){
                x--;
            } else if(dp[x][y] == dp[x][y-1]){
                y--;
            } else {
                sb.append(A.charAt(x-1));
                x--;
                y--;
            }
        }
        System.out.println(sb.reverse());
    }
}
