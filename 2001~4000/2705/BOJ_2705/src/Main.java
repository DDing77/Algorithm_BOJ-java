import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int T;
    int N;
    int[] dp;

    private void solution() throws IOException {

        dp = new int[1_001];
        Arrays.fill(dp, 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((i - j) % 2 == 1) {
                    continue;
                }
                dp[i] += dp[(i - j) / 2];
            }
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
