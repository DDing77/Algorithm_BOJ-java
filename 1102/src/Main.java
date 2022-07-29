import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, P;
    static int res;
    static int bit;
    static int[][] arr;
    static int[][] dp;
    static int cnt;

    static int solve(int bit, int cnt) {
        if (cnt >= P)
            return 0;

        if (dp[bit][cnt] != -1)
            return dp[bit][cnt];

        dp[bit][cnt] = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if ((bit & (1 << i)) != 0) {
                for (int j = 0; j < N; j++) {
                    if ((bit & (1 << j)) == 0) {
                        dp[bit][cnt] = Math.min(dp[bit][cnt], solve(bit | (1 << j), cnt + 1) + arr[i][j]);
                    }
                }
            }
        }
        return dp[bit][cnt];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        String input = br.readLine();
        bit = 0;
        cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'Y') {
                bit = bit | (1 << i);
                cnt++;
            }
        }

        dp = new int[1 << N][N + 1];
        P = Integer.parseInt(br.readLine());
        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], -1);
        }

        res = solve(bit, cnt);

        if (res != Integer.MAX_VALUE)
            System.out.println(res);
        else
            System.out.println(-1);
    }
}
