import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int K;
    private int[][] board;
    private Queue<int[]> cache;

    private void printBoard() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void execBFS(int x, int y) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});

        cache.add(new int[]{x, y});

        boolean[][] isVisited = new boolean[N][10];
        isVisited[x][y] = true;
        int target = board[x][y];

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= 10) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == target) {
                    isVisited[nX][nY] = true;
                    que.add(new int[]{nX, nY});
                    cache.add(new int[]{nX, nY});
                }
            }
        }
    }

    private boolean isPopped() {

        boolean isPop = false;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 9; j >= 0; j--) {
                if (board[i][j] == 0) {
                    continue;
                }

                cache.clear();
                execBFS(i, j);
                if (cache.size() >= K) {
                    isPop = true;
                    while (!cache.isEmpty()) {
                        int[] cur = cache.poll();
                        board[cur[0]][cur[1]] = 0;
                    }
                }
            }
        }

        return isPop;
    }

    private void down() {

        for (int i = 0; i < 10; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (board[j][i] != 0) {
                    int idx = j;
                    while (idx + 1 < N && board[idx + 1][i] == 0) {
                        board[idx + 1][i] = board[idx][i];
                        board[idx][i] = 0;
                        idx++;
                    }
                }
            }
        }

    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][10];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < 10; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        cache = new ArrayDeque<>();
        while (isPopped()) {
            down();
        }

        printBoard();
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
