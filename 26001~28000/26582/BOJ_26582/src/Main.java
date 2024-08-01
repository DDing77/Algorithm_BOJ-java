import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int n;
    private int i;
    private int w;
    private int[] dp;

    private void solution() throws IOException {

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dp = new int[w + 1];
            for (int j = 0; j < i; j++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                for (int k = w; k >= weight; k--) {
                    dp[k] = Math.max(dp[k], dp[k - weight] + value);
                }
            }

            sb.append(dp[w]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
