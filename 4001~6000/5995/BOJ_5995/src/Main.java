import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int H;
    private int N;
    private int[] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[H + 1];

        for (int i = 1; i <= N; i++) {
            int W = Integer.parseInt(br.readLine());
            for (int j = H; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + W);
            }
        }

        System.out.println(dp[H]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
