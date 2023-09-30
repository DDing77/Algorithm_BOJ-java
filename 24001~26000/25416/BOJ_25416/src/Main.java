import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final int SIZE = 5;
    int[][] board;
    int r;
    int c;
    int[][] dp;
    int res;

    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r, c});
        board[r][c] = -1;

        res = -1;
        dp = new int[SIZE][SIZE];

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (board[cur[0]][cur[1]] == 1) {
                res = dp[cur[0]][cur[1]];
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= SIZE || nY < 0 || nY >= SIZE) {
                    continue;
                }
                if (board[nX][nY] == -1) {
                    continue;
                }
                if (dp[nX][nY] != 0) {
                    continue;
                }

                dp[nX][nY] = dp[cur[0]][cur[1]] + 1;
                que.add(new int[]{nX, nY});
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
