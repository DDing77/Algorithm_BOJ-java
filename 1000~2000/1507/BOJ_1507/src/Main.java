import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] distances;
    private int[][] dp;
    private int res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        distances = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distances[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = distances[i][j];
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || i == k || k == j) {
                        continue;
                    }

                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        System.out.println("-1");
                        return;
                    }

                    if (distances[i][j] == distances[i][k] + distances[k][j]) {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                    res += dp[i][j];
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
