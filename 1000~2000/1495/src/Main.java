import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] volume;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volume = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[M + 1][N];
        for (int[] arr : dp) {
            Arrays.fill(arr, -2);
        }

        bw.write(recursion(S, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int recursion(int sum, int idx) {
        if (sum > M || sum < 0) {
            return -1;
        }
        if (idx == N) {
            return sum;
        }
        if (dp[sum][idx] != -2) {
            return dp[sum][idx];
        }
        return dp[sum][idx] = Math.max(dp[sum][idx],
                Math.max(recursion(sum + volume[idx], idx + 1), recursion(sum - volume[idx], idx + 1)));
    }

}