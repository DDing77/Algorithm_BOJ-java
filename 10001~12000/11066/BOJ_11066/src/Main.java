import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private int[] prefixSum;
    private int[][] dp;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            prefixSum = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(st.nextToken());
                prefixSum[i] = prefixSum[i - 1] + value;
            }

            dp = new int[N + 1][N + 1];

            for (int size = 1; size <= N; size++) {
                for (int start = 1; start + size <= N; start++) {
                    int end = start + size;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + (prefixSum[end] - prefixSum[start - 1]));
                    }
                }
            }

            sb.append(dp[1][N]).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
