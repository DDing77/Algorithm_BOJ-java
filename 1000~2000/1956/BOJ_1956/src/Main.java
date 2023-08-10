import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    final int INF = 987654321;
    int V;
    int E;
    int[][] dp;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = readInt();
        E = readInt();

        dp = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(dp[i], INF);
        }

        while (E-- > 0) {
            dp[readInt() - 1][readInt() - 1] = readInt();
        }

        res = INF;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    if (i == j) {
                        res = Math.min(res, dp[i][j]);
                    }
                }
            }
        }

        if (res == INF) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
}
