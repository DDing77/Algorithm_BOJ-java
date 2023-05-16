import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int length;
    static int[] prefixSum;
    static int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        length = Integer.parseInt(br.readLine());

        dp = new int[N + 1][4];
        for (int i = 1; i <= 3; i++) {
            for (int j = length * i; j <= N; j++) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - length][i - 1] + prefixSum[j] - prefixSum[j - length]);
            }
        }

        System.out.println(dp[N][3]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
