import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        Arrays.fill(dp, 987654321);

        int i = 1;
        while (true) {
            int size = i * (i + 1) * (i + 2) / 6;
            i++;

            if (size > N) {
                break;
            }

            dp[size] = 1;
            for (int j = size; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - size] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
