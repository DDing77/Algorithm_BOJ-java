import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int M;
    private int K;
    private List<Integer> prettyNumbers;
    private int[] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prettyNumbers = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int sum = 0;
            int cur = i;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }

            if (i % sum == 0) {
                prettyNumbers.add(i);
            }
        }

        dp = new int[M + 1];
        dp[0] = 1;
        for (Integer prettyNumber : prettyNumbers) {
            for (int i = prettyNumber; i <= M; i++) {
                dp[i] += dp[i - prettyNumber];
                dp[i] %= K;
            }
        }

        System.out.println(dp[M]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
