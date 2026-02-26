import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private String A;
    private String B;
    private String C;
    private int[][] dp;

    private void initDP(int aLength, int bLength) {
        dp = new int[255][255];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    private boolean execDFS(int aIdx, int bIdx) {
        if (aIdx + bIdx == C.length()) {
            return true;
        }
        if (dp[aIdx][bIdx] == 0) {
            return false;
        }
        if (dp[aIdx][bIdx] == 1) {
            return true;
        }

        boolean ret = false;
        if (aIdx < A.length() && A.charAt(aIdx) == C.charAt(aIdx + bIdx)) {
            ret |= execDFS(aIdx + 1, bIdx);
        }
        if (bIdx < B.length() && B.charAt(bIdx) == C.charAt(bIdx + aIdx)) {
            ret |= execDFS(aIdx, bIdx + 1);
        }

        if (ret) {
            dp[aIdx][bIdx] = 1;
        } else {
            dp[aIdx][bIdx] = 0;
        }

        return ret;
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();
            C = st.nextToken();

            initDP(A.length(), B.length());

            sb.append("Data set ").append(tc).append(": ");
            if (execDFS(0, 0)) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
