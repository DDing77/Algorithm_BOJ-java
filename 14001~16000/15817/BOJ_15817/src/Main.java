import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int x;
    private int[] dp;
    private int[][] pipes;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        pipes = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pipes[i][0] = Integer.parseInt(st.nextToken());
            pipes[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = x; j >= 0; j--) {
                for (int k = 1; k <= pipes[i][1]; k++) {
                    if (j - k * pipes[i][0] >= 0) {
                        dp[j] += dp[j - k * pipes[i][0]];
                    }
                }
            }
        }

        System.out.println(dp[x]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
