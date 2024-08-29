import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] dp;
    private int resMax;
    private int resGradeNumber;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][6];

        resMax = -1;
        resGradeNumber = 6;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            dp[i][a] = dp[i - 1][a] + 1;

            if (dp[i][a] > resMax) {
                resMax = dp[i][a];
                resGradeNumber = a;
            } else if (dp[i][a] == resMax) {
                resGradeNumber = Math.min(resGradeNumber, a);
            }

            int b = Integer.parseInt(st.nextToken());

            if (a == b) {
                continue;
            }

            dp[i][b] = dp[i - 1][b] + 1;

            if (dp[i][b] > resMax) {
                resMax = dp[i][b];
                resGradeNumber = b;
            } else if (dp[i][b] == resMax) {
                resGradeNumber = Math.min(resGradeNumber, b);
            }
        }

        sb.append(resMax).append(" ").append(resGradeNumber);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
