import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    private int R;
    private int C;
    private char[][] board;
    private boolean isFind;
    private int res;

    private void execDFS(int x, int y) {

        if (y == C - 1) {
            res++;
            isFind = true;
            return;
        }

        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (nX < 0 || nX >= R || nY >= C) {
                continue;
            }

            if (board[nX][nY] == 'x') {
                continue;
            }

            board[nX][nY] = 'x';
            execDFS(nX, nY);

            if (isFind) {
                return;
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (board[i][0] == '.') {
                isFind = false;
                execDFS(i, 0);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
