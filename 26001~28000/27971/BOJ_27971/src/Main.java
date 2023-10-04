import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int[] puppy;
    boolean[] range;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        puppy = new int[2];
        puppy[0] = Integer.parseInt(st.nextToken());
        puppy[1] = Integer.parseInt(st.nextToken());

        range = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            for (int j = left; j <= right; j++) {
                range[j] = true;
            }
        }

        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < puppy.length; j++) {
                if (range[i]) {
                    continue;
                }
                if (i - puppy[j] >= 0 && dp[i - puppy[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - puppy[j]] + 1);
                }
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
        
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
