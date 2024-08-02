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
    private int W;
    private int[] weights;
    private int[] preferences;
    private int[] dp;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            W = Integer.parseInt(br.readLine());

            weights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            preferences = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                preferences[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[W + 1];
            for (int i = 0; i < N; i++) {
                for (int j = W; j >= 1; j--) {
                    if (j - weights[i] >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - weights[i]] + preferences[i]);
                    }
                }
            }

            sb.append(dp[W]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
