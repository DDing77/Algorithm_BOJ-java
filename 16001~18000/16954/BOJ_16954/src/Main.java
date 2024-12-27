import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int LENGTH = 8;
    private static final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    private char[][] board;
    private boolean res;

    private void solution() throws IOException {

        board = new char[LENGTH][LENGTH];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[LENGTH][LENGTH];

        if (board[LENGTH - 1][0] == '.') {
            que.add(new int[]{LENGTH - 1, 0});
            isVisited[LENGTH - 1][0] = true;
        }

        bfs: while (!que.isEmpty()) {
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                int[] cur = que.poll();

                if (board[cur[0]][cur[1]] == '#') {
                    continue;
                }

                if (cur[0] == 0 && cur[1] == LENGTH - 1) {
                    res = true;
                    break bfs;
                }

                for (int[] nextDir : dir) {
                    int nX = cur[0] + nextDir[0];
                    int nY = cur[1] + nextDir[1];
                    if (nX < 0 || nX >= LENGTH || nY < 0 || nY >= LENGTH) {
                        continue;
                    }

                    if (isVisited[nX][nY]) {
                        continue;
                    }

                    if (board[nX][nY] == '.') {
                        que.add(new int[]{nX, nY});
                        isVisited[nX][nY] = true;
                    }
                }
            }

            Arrays.fill(board[LENGTH - 1], '.');

            for (int i = LENGTH - 2; i >= 0; i--) {
                for (int j = 0; j < LENGTH; j++) {
                    if (board[i][j] == '#') {
                        board[i + 1][j] = board[i][j];
                        board[i][j] = '.';
                    }
                }
            }
        }

        if (res) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
