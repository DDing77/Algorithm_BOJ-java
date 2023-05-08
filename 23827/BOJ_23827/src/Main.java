import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private final int MOD = 1_000_000_007;
    private int N;
    private long[] prefixSum;
    private long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        prefixSum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        res = 0L;
        for (int i = 1; i < N; i++) {
            res += (prefixSum[i] - prefixSum[i - 1]) * (prefixSum[N] - prefixSum[i]);
            res %= MOD;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
