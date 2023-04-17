import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n;
    private int[][] map;
    private int[][] dp;
    private int res;

    public int execDFS(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for (int k = 0; k < 4; k++) {
            int nX = x + dir[k][0];
            int nY = y + dir[k][1];

            if (nX < 0 || nX >= n || nY < 0 || nY >= n) {
                continue;
            }

            if (map[x][y] < map[nX][nY]) {
                dp[x][y] = Math.max(dp[x][y], execDFS(nX, nY) + 1);
            }
        }

        return dp[x][y];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    res = Math.max(res, execDFS(i, j));
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
