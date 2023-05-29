import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static int[] card;
    static int[][] dp;
    static int res;

    static int gw(int left, int right) {
        if (dp[left][right] != 0)
            return dp[left][right];
        if (left == right)
            return card[left];

        dp[left][right] = Math.max(card[left] + mw(left + 1, right), card[right] + mw(left, right - 1));
        return dp[left][right];
    }

    static int mw(int left, int right) {
        if (dp[left][right] != 0)
            return dp[left][right];

        if (left == right)
            return 0;

        dp[left][right] = Math.min(gw(left + 1, right), gw(left, right - 1));
        return dp[left][right];
    }

    static int solution() {
        res = 0;
        dp = new int[N + 1][N + 1];
        res = gw(1, N);
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            card = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                card[i] = Integer.parseInt(st.nextToken());

            sb.append(solution()).append('\n');
        }
        System.out.print(sb);
    }
}
