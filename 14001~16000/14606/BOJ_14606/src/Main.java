import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] dp;

    private int getDp(int cur) {

        if (cur <= 1) {
            return 0;
        }

        if (dp[cur] != 0) {
            return dp[cur];
        }

        return dp[cur] += getDp((cur + 1) / 2) + getDp(cur / 2) + ((cur + 1) / 2) * (cur / 2);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        getDp(N);

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}