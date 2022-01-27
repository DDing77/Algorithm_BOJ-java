import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans = 0;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int target = 0;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) target = Math.max(dp[j], target);
            }
            dp[i] = target + 1;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
