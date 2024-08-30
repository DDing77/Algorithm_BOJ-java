import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] ratings;
    private int[] dp;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        ratings = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ratings[i] = Integer.parseInt(br.readLine());
            dp[i] = ratings[i];
            for (int j = 0; j < i; j++) {
                if (ratings[j] < ratings[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + ratings[i]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
