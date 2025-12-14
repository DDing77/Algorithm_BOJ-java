import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int N;
    private int[][] board;
    private int[][] dp;

    private void dijkstra() {
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 987654321);
        }
        dp[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (dp[cur[0]][cur[1]] < cur[2]) {
                continue;
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nY < 0 || nX >= N || nY >= N) {
                    continue;
                }

                int max = Math.max(cur[2], Math.abs(board[cur[0]][cur[1]] - board[nX][nY]));

                if (dp[nX][nY] > max) {
                    dp[nX][nY] = max;
                    pq.add(new int[]{nX, nY, max});
                }
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstra();

        System.out.println(dp[N - 1][N - 1]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
