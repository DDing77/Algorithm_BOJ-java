import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int C;
    static int[] dp;

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[1001];
        dp[0] = 0;
        dp[1] = 3;

        for (int i = 2; i <= 1000; i++) {
            int cnt = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) cnt++;
            }
            dp[i] = dp[i - 1] + cnt * 2;
        }

        C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }
        System.out.print(sb);
    }
}
