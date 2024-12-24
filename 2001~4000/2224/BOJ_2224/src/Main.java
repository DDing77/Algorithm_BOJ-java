import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new int[52][52];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 52);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char from = st.nextToken().charAt(0);
            int intFrom;
            if ('A' <= from && from <= 'Z') {
                intFrom = from - 'A';
            } else {
                intFrom = from - 'a' + 26;
            }

            st.nextToken();

            char to = st.nextToken().charAt(0);
            int intTo;
            if ('A' <= to && to <= 'Z') {
                intTo = to - 'A';
            } else {
                intTo = to - 'a' + 26;
            }
            dp[intFrom][intTo] = 1;
        }

        for (int k = 0; k < dp.length; k++) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp.length; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j] != 52 && i != j) {
                    cnt++;
                    if (i < 26) {
                        sb.append((char) (i + 'A')).append(" => ");
                    } else {
                        sb.append((char) (i + 'a' - 26)).append(" => ");
                    }

                    if (j < 26) {
                        sb.append((char) (j + 'A'));
                    } else {
                        sb.append((char) (j + 'a' - 26));
                    }

                    sb.append("\n");
                }
            }
        }

        sb.insert(0, cnt + "\n");
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
