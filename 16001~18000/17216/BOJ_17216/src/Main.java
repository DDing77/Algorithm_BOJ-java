import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] numbers;
    private int[] dp;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + numbers[i]);
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
