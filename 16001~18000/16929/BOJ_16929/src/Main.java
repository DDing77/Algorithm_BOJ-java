import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private char[][] board;
    private boolean[][] isVisited;
    private boolean res;

    private void execDFS(int startX, int startY, int curX, int curY, char target, int depth) {

        if (res) {
            return;
        }

        if (depth >= 4 && (Math.abs(startX - curX) + Math.abs(startY - curY)) == 1) {
            res = true;
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int nX = curX + dir[i][0];
            int nY = curY + dir[i][1];

            if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                continue;
            }
            if (isVisited[nX][nY]) {
                continue;
            }
            if (board[nX][nY] != target) {
                continue;
            }

            isVisited[nX][nY] = true;
            execDFS(startX, startY, nX, nY, target, depth + 1);
            isVisited[nX][nY] = false;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (res) {
                    System.out.println("Yes");
                    return;
                }
                isVisited = new boolean[N][M];
                isVisited[i][j] = true;
                execDFS(i, j, i, j, board[i][j], 1);
            }
        }

        System.out.println("No");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
