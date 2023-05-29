import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] dp;
    static HashMap<Integer, Integer> map;
    static long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();
        map.put(0, 1);

        res = 0L;
        for (int i = 1; i <= N; i++) {
            res += map.getOrDefault(dp[i] - K, 0);
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
