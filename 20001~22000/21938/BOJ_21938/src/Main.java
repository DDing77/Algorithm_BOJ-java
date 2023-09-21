import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int M;
    int T;
    int[][] board;
    boolean[][] isVisited;
    int res;

    public void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < dir.length; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] < T) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        N = readInt();
        M = readInt();

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = (readInt() + readInt() + readInt()) / 3;
            }
        }

        T = readInt();
        isVisited = new boolean[N][M];
        res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] >= T && !isVisited[i][j]) {
                    res++;
                    execBFS(i, j);
                }
            }
        }

        System.out.println(res);
    }

    public int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
