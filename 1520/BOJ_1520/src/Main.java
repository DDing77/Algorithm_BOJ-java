import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int N, M;
    private int[][] map;
    private int[][] dp;

    public int execDFS(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1;
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int k = 0; k < 4; k++) {
                int nX = x + dir[k][0];
                int nY = y + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (map[x][y] <= map[nX][nY]) {
                    continue;
                }

                dp[x][y] += execDFS(nX, nY);
            }
        }

        return dp[x][y];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(execDFS(0, 0));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
