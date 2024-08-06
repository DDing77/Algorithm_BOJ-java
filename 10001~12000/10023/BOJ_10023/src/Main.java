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
    private int B;
    private int[] breads;
    private int[] volumes;
    private int max;
    private int[] dp;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        breads = new int[B];
        for (int i = 0; i < B; i++) {
            breads[i] = Integer.parseInt(br.readLine());
        }

        volumes = new int[N];
        max = 0;
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, volumes[i]);
        }

        dp = new int[max + 1];
        Arrays.fill(dp, 987654321);

        dp[0] = 0;
        for (int i = 0; i < B; i++) {
            for (int j = breads[i]; j <= max; j++) {
                dp[j] = Math.min(dp[j], dp[j - breads[i]] + 1);
            }
        }

        int pre = 0;
        for (int i = 0; i < N; i++) {
            int cur = volumes[i] - pre;
            if (dp[cur] == 987654321) {
                res = -1;
                break;
            }

            pre += cur;
            res += dp[cur];

            if (pre > 0) {
                pre--;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
