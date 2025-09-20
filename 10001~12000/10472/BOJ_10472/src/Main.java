import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MAX_SIZE = 1 << 9;
    private static final int BOARD_SIZE = 3;
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int T;
    private char[][] board;
    private boolean[] isVisited;
    private int status;
    private int res;

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            board = new char[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                board[i] = br.readLine().toCharArray();
            }

            status = 0;
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == '*') {
                        status += 1 << ((BOARD_SIZE * BOARD_SIZE - 1) - (i * 3 + j));
                    }
                }
            }

            isVisited = new boolean[MAX_SIZE];
            isVisited[status] = true;
            Queue<int[]> que = new ArrayDeque<>();
            que.add(new int[]{status, 0});

            res = 0;
            while (!que.isEmpty()) {
                int[] cur = que.poll();

                if (cur[0] == 0) {
                    res = cur[1];
                    break;
                }

                for (int i = 0; i < BOARD_SIZE * BOARD_SIZE; i++) {
                    int x = i / BOARD_SIZE;
                    int y = i % BOARD_SIZE;
                    int nextStatus = cur[0] ^ (1 << ((BOARD_SIZE * BOARD_SIZE - 1 - i)));

                    for (int[] dir : dirs) {
                        int nX = x + dir[0];
                        int nY = y + dir[1];

                        if (nX < 0 || nX >= BOARD_SIZE || nY < 0 || nY >= BOARD_SIZE) {
                            continue;
                        }

                        nextStatus ^= 1 << ((BOARD_SIZE * BOARD_SIZE - 1) - (nX * 3 + nY));
                    }

                    if (isVisited[nextStatus]) {
                        continue;
                    }

                    isVisited[nextStatus] = true;
                    que.add(new int[]{nextStatus, cur[1] + 1});
                }
            }
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
