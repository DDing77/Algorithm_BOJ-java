import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int T;
    int N;
    int[] dp;

    private int lowerBound(int length, int target) {

        int left = -1;
        int right = length;

        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (dp[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private void solution() throws IOException {

        String input;
        while ((input = br.readLine()) != null) {
            N = Integer.parseInt(input.trim());

            dp = new int[N];
            st = new StringTokenizer(br.readLine());
            int idx = 0;

            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(st.nextToken());

                if (dp[idx] < cur) {
                    dp[++idx] = cur;
                } else {
                    dp[lowerBound(idx, cur)] = cur;
                }
            }

            sb.append(idx).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
