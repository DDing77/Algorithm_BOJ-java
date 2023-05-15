import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int N;
    private int M;
    private int Q;
    private long[][] dp;
    private int r1;
    private int c1;
    private int r2;
    private int c2;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = read();
        M = read();
        Q = read();

        dp = new long[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + read();
            }
        }

        int cnt = 0;
        while (Q-- > 0) {
            r1 = read();
            c1 = read();
            r2 = read();
            c2 = read();

            cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
            sb.append((dp[r2][c2] + dp[r1 - 1][c1 - 1] - dp[r2][c1 - 1] - dp[r1 - 1][c2]) / cnt).append('\n');
        }

        System.out.print(sb);
    }

    public int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
