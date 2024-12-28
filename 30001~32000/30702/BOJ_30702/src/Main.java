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

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private char[][] board1;
    private char[][] board2;
    private boolean[][] isVisited;

    private void execBFS(int x, int y, char before, char after) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;
        board1[x][y] = after;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board1[nX][nY] != before) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
                board1[nX][nY] = after;
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board1 = new char[N][M];
        for (int i = 0; i < N; i++) {
            board1[i] = br.readLine().toCharArray();
        }

        board2 = new char[N][M];
        for (int i = 0; i < N; i++) {
            board2[i] = br.readLine().toCharArray();
        }

        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board1[i][j] != board2[i][j]) {
                    if (isVisited[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                    execBFS(i, j, board1[i][j], board2[i][j]);
                }
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

