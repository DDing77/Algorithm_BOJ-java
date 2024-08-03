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
    private int[] time;
    private double[] cost;
    private double[] dp;
    private int totalTime;
    private int resTime;

    private void solution() throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            time = new int[N];
            cost = new double[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                time[i] = Integer.parseInt(st.nextToken());
                cost[i] = Double.parseDouble(st.nextToken());
            }

            totalTime = Integer.parseInt(br.readLine());

            dp = new double[totalTime + 1];
            for (int i = 0; i < N; i++) {
                for (int j = totalTime; j >= 1; j--) {
                    if (j - time[i] >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - time[i]] + cost[i]);
                    }
                }
            }

            resTime = totalTime;
            while (dp[resTime] == dp[resTime - 1]) {
                resTime--;
            }

            sb.append("Problem ")
                    .append(tc)
                    .append(": ")
                    .append(resTime)
                    .append(" seconds scheduled for $")
                    .append(String.format("%.2f", dp[totalTime]))
                    .append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
