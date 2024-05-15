import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private BigInteger[] dp;

    private void solution() throws IOException {

        dp = new BigInteger[251];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1].add((dp[i - 2].multiply(new BigInteger("2"))));
        }

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb.append(dp[N]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
