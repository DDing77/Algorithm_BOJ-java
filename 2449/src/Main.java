import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int[][] dp;

    static int getDP(int start, int end) {
        if (start == end) return 0;
        if (dp[start][end] != Integer.MAX_VALUE) return dp[start][end];
        for (int i = start; i < end; i++) {
            int cnt = 0;
            if (arr[start] != arr[i + 1]) cnt = 1;
            dp[start][end] = Math.min(dp[start][end], getDP(start, i) + getDP(i + 1, end) + cnt);
        }
        return dp[start][end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int res = getDP(0, N - 1);

        System.out.println(res);
    }
}
