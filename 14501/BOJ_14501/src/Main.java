import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] dp;
    static int[] T, P;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        T = new int[N + 15];
        P = new int[N + 15];
        dp = new int[N + 15];

        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[T[i] + i] = Math.max(dp[T[i] + i], P[i] + dp[i]);
            max = Math.max(max, dp[i]);

        }
        System.out.println(max);
    }
}