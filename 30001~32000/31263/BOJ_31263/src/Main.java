import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] arr;
    private int[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        if (N <= 2) {
            System.out.println(1);
            return;
        }

        arr = new int[N + 1];
        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i + 1] = input.charAt(i) - '0';
        }

        dp = new int[N + 1];
        Arrays.fill(dp, 5000);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            int value;
            if (arr[i - 2] != 0) {
                value = arr[i - 2] * 100 + arr[i - 1] * 10 + arr[i];
                if (value <= 641) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + 1);
                }
            }
            if (arr[i - 1] != 0) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (arr[i] != 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
