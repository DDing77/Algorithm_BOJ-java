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

    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int N;
    private int M;
    private int[][] board;
    private boolean[][] isVisited;
    private int res;

    private void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0) {
                    nX += N;
                } else if (nX == N) {
                    nX = 0;
                } else if (nY < 0) {
                    nY += M;
                } else if (nY == M) {
                    nY = 0;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == 1) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0 && !isVisited[i][j]) {
                    res++;
                    execBFS(i, j);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
