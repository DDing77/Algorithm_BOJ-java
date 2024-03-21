import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] dp;
    int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        res = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            dp[i] = time;

            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                dp[i] = Math.max(dp[i], time + dp[Integer.parseInt(st.nextToken())]);
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
