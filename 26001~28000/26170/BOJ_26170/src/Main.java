import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int ROW = 5;
    private static final int COL = 5;

    private int[][] board;
    private int x;
    private int y;
    private boolean[][] isVisited;
    private int minRes;

    private void execDFS(int x, int y, int eatenCount, int moveCount) {

        if (eatenCount == 3) {
            minRes = Math.min(minRes, moveCount);
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (nX < 0 || nX >= ROW || nY < 0 || nY >= COL) {
                continue;
            }

            if (board[nX][nY] != -1 && !isVisited[nX][nY]) {
                isVisited[nX][nY] = true;
                int nextEatenCount = eatenCount + board[nX][nY];
                int nextMovCount = moveCount + 1;
                execDFS(nX, nY, nextEatenCount, nextMovCount);
                isVisited[nX][nY] = false;
            }
        }
    }

    private void solution() throws IOException {

        board = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        isVisited = new boolean[ROW][COL];
        minRes = Integer.MAX_VALUE;
        isVisited[x][y] = true;
        execDFS(x, y, 0, 0);

        if (minRes == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minRes);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
