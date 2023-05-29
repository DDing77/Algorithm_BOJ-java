import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final int MAX_LENGTH = 200;
    private int T;
    private int N;
    private int[] dp;
    private int max;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            dp = new int[MAX_LENGTH];
            N = Integer.parseInt(br.readLine());

            int from;
            int to;
            int temp;
            max = 0;

            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                from = (Integer.parseInt(st.nextToken()) - 1) / 2;
                to = (Integer.parseInt(st.nextToken()) - 1) / 2;

                if (from > to) {
                    temp = from;
                    from = to;
                    to = temp;
                }
                for (int i = from; i <= to; i++) {
                    dp[i] += 10;
                    max = Math.max(max, dp[i]);
                }
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
