import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private double W;
    private double L;
    private double D;
    private double[][] dp;
    private double bronze;
    private double silver;
    private double gold;
    private double platinum;
    private double diamond;

    private double getSum(int start, int end) {

        double sum = 0.0;
        for (int i = start; i < end; i++) {
            sum += dp[20][i];
        }

        return sum;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        W = Double.parseDouble(st.nextToken());
        L = Double.parseDouble(st.nextToken());
        D = Double.parseDouble(st.nextToken());

        dp = new double[21][3501];
        dp[0][2000] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1000; j <= 3000; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                dp[i][j + 50] += dp[i - 1][j] * W;
                dp[i][j - 50] += dp[i - 1][j] * L;
                dp[i][j] += dp[i - 1][j] * D;
            }
        }

        bronze = getSum(1000, 1500);
        silver = getSum(1500, 2000);
        gold = getSum(2000, 2500);
        platinum = getSum(2500, 3000);
        diamond = getSum(3000, 3001);

        sb.append(String.format("%.8f", bronze)).append('\n')
                .append(String.format("%.8f", silver)).append('\n')
                .append(String.format("%.8f", gold)).append('\n')
                .append(String.format("%.8f", platinum)).append('\n')
                .append(String.format("%.8f", diamond));

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
