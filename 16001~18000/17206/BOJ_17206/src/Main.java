import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int[] numbers;
    private long[][] dp;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        numbers = new int[T];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[80_001][2];

        long sum = 0L;
        for (int i = 0; i < dp.length; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
            dp[i][0] = sum;
        }

        sum = 0L;
        for (int i = 0; i < dp.length; i++) {
            if (i % 7 == 0 && i % 3 != 0) {
                sum += i;
            }
            dp[i][1] = sum;
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[numbers[i]][0] + dp[numbers[i]][1]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
