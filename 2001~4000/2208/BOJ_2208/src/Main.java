import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int[] jewels;
    int[] prefixSum;
    int[] dp;
    int resMax;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        jewels = new int[N + 1];
        prefixSum = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i - 1] + jewels[i];
        }

        dp[M] = prefixSum[M];
        resMax = dp[M];
        for (int i = M + 1; i <= N; i++) {
            dp[i] = Math.max(prefixSum[i] - prefixSum[i - M], dp[i - 1] + jewels[i]);
            resMax = Math.max(resMax, dp[i]);
        }

        System.out.println(Math.max(0, resMax));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
