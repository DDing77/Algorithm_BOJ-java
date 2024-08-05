import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX = 1_000_001;
    private int[] energy;
    private int K;
    private int[] dir = {3, 1, 2};
    private int[][] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        energy = new int[3];
        for (int i = 0; i < energy.length; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1][4];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], MAX);
        }

        dp[0][0] = 0;
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] != MAX) {
                    for (int k = 0; k < energy.length; k++) {
                        if (i + energy[k] <= K) {
                            dp[i + energy[k]][(j + dir[k]) % 4] = Math.min(dp[i + energy[k]][(j + dir[k]) % 4], dp[i][j] + 1);
                        }
                    }
                }
            }
        }

        if (dp[K][0] != MAX) {
            System.out.println(dp[K][0]);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
