import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[1001];


        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            check = new boolean[16];

            for (int j = 0; j <= i - 2; j++) {
                int temp = dp[j] ^ dp[i - j - 2];
                check[temp] = true;
            }

            for (int j = 0; j <= 15; j++) {
                if (!check[j]) {
                    dp[i] = j;
                    break;
                }
            }
        }
        if (dp[N] == 0) System.out.println(2);
        else System.out.println(1);
    }
}
