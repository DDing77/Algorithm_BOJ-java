import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int max = 0;

        java.util.StringTokenizer st =
                new java.util.StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            dp[x] = dp[x - 1] + 1;
            max = Math.max(max, dp[x]);
        }

        System.out.println(n - max);
    }
}
