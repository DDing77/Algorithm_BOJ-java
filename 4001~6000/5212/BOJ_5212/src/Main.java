import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int N;
    private int M;
    private char[][] board;

    private boolean check(int x, int y) {
        int count = 0;

        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                count++;
                continue;
            }

            if (board[nX][nY] == '.') {
                count++;
            }
        }

        return count >= 3;
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
                if (board[i][j] == 'X' && check(i, j)) {
                    board[i][j] = 'O';
                }
            }
        }

        int startRow = 0;
        int endRow = N - 1;
        int startCol = 0;
        int endCol = M - 1;
        for (int i = 0; i < N; i++) {
            boolean find = false;
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'X') {
                    find = true;
                    break;
                }
            }

            if (find) {
                startRow = i;
                break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            boolean find = false;
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'X') {
                    find = true;
                    break;
                }
            }

            if (find) {
                endRow = i;
                break;
            }
        }

        for (int i = 0; i < M; i++) {
            boolean find = false;
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 'X') {
                    find = true;
                    break;
                }
            }

            if (find) {
                startCol = i;
                break;
            }
        }

        for (int i = M - 1; i >= 0; i--) {
            boolean find = false;
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 'X') {
                    find = true;
                    break;
                }
            }

            if (find) {
                endCol = i;
                break;
            }
        }

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] == 'X') {
                    sb.append('X');
                } else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
