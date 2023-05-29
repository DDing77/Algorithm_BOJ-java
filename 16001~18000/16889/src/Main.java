import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int res = 0;

        dp = new int[1010101];

        for (int i = 1, cnt = 1; i <= 60; i++, cnt++) {
            int n = i * (i + 1) / 2;

            for (int j = 0; j <= cnt; j++) {
                dp[n + j] = cnt;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            res ^= dp[temp];
        }

        if (res == 0) System.out.println("cubelover");
        else System.out.println("koosaga");
    }
}
