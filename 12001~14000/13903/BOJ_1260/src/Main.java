import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[][] dir;
    int R;
    int C;
    int N;
    int[][] board;
    boolean[][] isVisited;
    Queue<int[]> que;
    int res;

    public void execBFS() {
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == R - 1) {
                res = cur[2];
                return;
            }

            for (int i = 0; i < N; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }
                if (board[nX][nY] == 0) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        que = new ArrayDeque<>();
        isVisited = new boolean[R][C];

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 && board[i][j] == 1) {
                    que.add(new int[]{i, j, 0});
                    isVisited[i][j] = true;
                }
            }
        }

        N = Integer.parseInt(br.readLine());

        dir = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        res = -1;

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
