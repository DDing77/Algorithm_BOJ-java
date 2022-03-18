import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] dp;
    static int[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new boolean[N];
        stone = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) stone[i] = Integer.parseInt(st.nextToken());

        dp[0] = true;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dp[i] && (j - i) * (1 + Math.abs(stone[j] - stone[i])) <= K) dp[j] = true;
            }
        }
        if (dp[N - 1]) System.out.println("YES");
        else System.out.println("NO");
    }
}
