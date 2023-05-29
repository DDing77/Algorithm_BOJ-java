import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private int T;
    private int[] dp;
    private double cnt;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[10_001];
        cnt = 6;

        for (int i = 1; i < 4; i++) {
            dp[i] = i;
        }

        for (int i = 4; i < dp.length; i++) {
            cnt /= 2;
            dp[i] = dp[i - 3] + (int) cnt;
            cnt *= 2;
            cnt++;
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
