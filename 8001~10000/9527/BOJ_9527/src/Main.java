import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 55;
    static long A;
    static long B;
    static long[] dp;

    public void getDpTable() {
        dp = new long[MAX];
        dp[0] = 1L;

        for (int i = 1; i < MAX; i++) {
            dp[i] = dp[i - 1] * 2 + (1L << i);
        }
    }

    public long getPrefixSum(long n) {
        long res = n & 1;

        for (int i = MAX - 1; i > 0; i--) {
            if (((1L << i) & n) > 0L) {
                res += dp[i - 1] + (n - (1L << i) + 1);
                n -= 1L << i;
            }
        }

        return res;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        getDpTable();

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(getPrefixSum(B) - getPrefixSum(A - 1));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
