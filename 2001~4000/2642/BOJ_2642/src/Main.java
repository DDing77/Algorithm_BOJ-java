import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int LENGTH = 6;

    private int[][] board;
    private int[] pairs;
    private boolean[][] isVisited;
    private boolean res;

    private boolean isRange(int x, int y) {
        return 0 <= x && x < LENGTH && 0 <= y && y < LENGTH && board[x][y] != 0;
    }

    private void execDFS(int x, int y, int originNum, int originDir, int depth) {
        if (depth == 2) {
            return;
        }
        for (int i = 0; i < dirs.length; i++) {
            int nX = x + dirs[i][0];
            int nY = y + dirs[i][1];

            if (!isRange(nX, nY)) {
                continue;
            }
            if (isVisited[originNum][board[nX][nY]]) {
                continue;
            }


            isVisited[originNum][board[nX][nY]] = true;

            if (depth == 1 && originDir == i &&
                    (pairs[board[nX][nY]] == 0 || pairs[board[nX][nY]] == originNum)
                    && (pairs[originNum] == 0 || pairs[originNum] == board[nX][nY])) {
                pairs[board[nX][nY]] = originNum;
                pairs[originNum] = board[nX][nY];
                execDFS(nX, nY, originNum, i, depth + 1);
            } else {
                execDFS(nX, nY, originNum, originDir, depth);
            }
        }
    }

    private void solution() throws IOException {
        board = new int[LENGTH][LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < LENGTH; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pairs = new int[LENGTH + 1];
        isVisited = new boolean[LENGTH + 1][LENGTH + 1];
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i][i] = true;
        }

        res = true;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (board[i][j] != 0) {
                    for (int k = 0; k < dirs.length; k++) {
                        int nX = i + dirs[k][0];
                        int nY = j + dirs[k][1];

                        if (!isRange(nX, nY)) {
                            continue;
                        }

                        execDFS(nX, nY, board[i][j], k, 1);
                    }
                }
            }
        }

        for (int i = 1; i <= LENGTH; i++) {
            if (pairs[i] == 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(pairs[1]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
