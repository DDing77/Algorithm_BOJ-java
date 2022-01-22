import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int N, M, K;

    static void query(int n, int m, int k, StringBuilder sb) {
        // 단어 끝에 도달
        if (n + m == 0) {
            return;
        }
        // z만 남은경우
        else if (n == 0) {
            sb.append("z");
            query(n, m - 1, k, sb);
        }
        // a만 남은경우
        else if (m == 0) {
            sb.append("a");
            query(n - 1, m, k, sb);
        }
        // a, z 둘다 남은 경우 a를 고를 때 조합 수를 보고 판단
        else {
            int leftCount = combination(n + m - 1, m);
            if (leftCount >= k) {
                sb.append('a');
                query(n - 1, m, k, sb);
            } else {
                sb.append('z');
                query(n, m - 1, k - leftCount, sb);
            }
        }
    }

    static int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else if (dp[n][r] != 0) {
            return dp[n][r];
        } else {
            return dp[n][r] = Math.min((int) 1e9, combination(n - 1, r - 1) + combination(n - 1, r));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + M + 1][N + M + 1];
        query(N, M, K, sb);
        System.out.println(sb);
    }
}