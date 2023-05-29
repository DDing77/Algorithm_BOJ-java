import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int[] alpha = {
            3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1
    };
    static int[][] dp;
    static String A, B;

    public static int getHeight(int length) {
        int res = 1;
        for (int k = 0; k < length; k++) res *= 2;
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();
        int length = A.length() * 2;
        dp = new int[length - 1][length];

        int idx = 0;
        for (int i = 0; i < length; i += 2) {
            dp[0][i] = alpha[A.charAt(idx) - 'A'];
            dp[0][i + 1] = alpha[B.charAt(idx) - 'A'];
            idx++;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < length - 1; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
            }
            length--;
        }

        System.out.println(String.format("%02d", dp[A.length() * 2 - 2][0] * 10 + dp[A.length() * 2 - 2][1]));
    }
}