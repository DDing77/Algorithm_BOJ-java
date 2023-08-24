import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static final int LENGTH = 10;
    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[][] board;
    boolean[][] isVisited;
    int barnX;
    int barnY;
    int res;

    public void execBFS() {
        isVisited = new boolean[LENGTH][LENGTH];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{barnX, barnY, 0});
        res = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] ints : dir) {
                int nX = cur[0] + ints[0];
                int nY = cur[1] + ints[1];

                if (nX < 0 || nX >= LENGTH || nY < 0 || nY >= LENGTH) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == 'R') {
                    continue;
                }

                if (board[nX][nY] == 'L') {
                    System.out.println(cur[2]);
                    return;
                }

                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY, cur[2] + 1});
            }
            res++;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[LENGTH][LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < LENGTH; j++) {
                if (board[i][j] == 'B') {
                    barnX = i;
                    barnY = j;
                }
            }
        }

        execBFS();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
