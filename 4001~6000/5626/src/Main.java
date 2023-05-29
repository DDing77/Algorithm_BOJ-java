import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] input;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N];
        dp = new int[N][(N / 2) + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            if (input[i] > Math.min(i, (N - 1) - i)) {
                System.out.println(0);
                return;
            }
        }

        dp[0][0] = 1;
        for (int i = 1; i < N; i++) {
            int len = Math.min(i, (N - 1) - i);

            if (input[i] != -1) {
                for (int k = -1; k <= 1; k++) {
                    int adjHeight = input[i] + k;
                    if (adjHeight < 0) continue;

                    dp[i][input[i]] += dp[i - 1][adjHeight];
                    dp[i][input[i]] %= 1000000007;
                }

            } else {
                len = Math.min(i, (N - 1) - i);
                for (int j = 0; j <= len; j++) {
                    for (int k = -1; k <= 1; k++) {
                        int adjHeight = j + k;
                        if (adjHeight < 0) continue;

                        dp[i][j] += dp[i - 1][adjHeight];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }

        System.out.println(dp[N - 1][0] % 1000000007);
    }
}