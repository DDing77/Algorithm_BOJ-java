import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int[] boxes;
    private int[] dp;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        boxes = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);
        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[i] > boxes[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
