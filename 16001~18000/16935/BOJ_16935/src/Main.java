import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int R;
    private int[][] board;

    private void rotate1() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = board[N - 1 - i][j];
            }
        }
        board = temp;
    }

    private void rotate2() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = board[i][M - 1 - j];
            }
        }
        board = temp;
    }

    private void rotate3() {
        int[][] tempBoard = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tempBoard[i][j] = board[N - 1 - j][i];
            }
        }
        board = tempBoard;
        int temp = N;
        N = M;
        M = temp;
    }

    private void rotate4() {
        int[][] tempBoard = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tempBoard[i][j] = board[j][M - 1 - i];
            }
        }
        board = tempBoard;
        int temp = N;
        N = M;
        M = temp;
    }

    private void rotate5() {
        int[][] tempBoard = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempBoard[i][j] = board[i + N / 2][j];
                tempBoard[i][j + M / 2] = board[i][j];
                tempBoard[i + N / 2][j + M / 2] = board[i][j + M / 2];
                tempBoard[i + N / 2][j] = board[i + N / 2][j + M / 2];
            }
        }
        board = tempBoard;
    }

    private void rotate6() {
        int[][] tempBoard = new int[N][M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempBoard[i][j] = board[i][j + M / 2];
                tempBoard[i][j + M / 2] = board[i + N / 2][j + M / 2];
                tempBoard[i + N / 2][j + M / 2] = board[i + N / 2][j];
                tempBoard[i + N / 2][j] = board[i][j];
            }
        }
        board = tempBoard;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                rotate1();
            } else if (op == 2) {
                rotate2();
            } else if (op == 3) {
                rotate3();
            } else if (op == 4) {
                rotate4();
            } else if (op == 5) {
                rotate5();
            } else if (op == 6) {
                rotate6();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]).append(" ");
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
