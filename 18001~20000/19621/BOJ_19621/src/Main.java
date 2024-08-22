import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] meetings;
    private int[][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        meetings = new int[N][3];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
            meetings[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        dp[0][1] = meetings[0][2];

        for (int i = 1; i < N; i++) {
            if (meetings[i][0] < meetings[i -1][1]) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + meetings[i][2];
            } else {
                dp[i][1] = dp[i - 1][1] + meetings[i][2];
            }
        }

        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
