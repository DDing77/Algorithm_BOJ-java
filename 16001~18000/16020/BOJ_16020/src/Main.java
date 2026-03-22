import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] board;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int rotateCount = 0; rotateCount < 4; rotateCount++) {
            if (isOriginal(board)) {
                printBoard(board);
                return;
            }
            board = rotate90(board);
        }
    }

    private boolean isOriginal(int[][] array) {
        for (int row = 0; row < N; row++) {
            for (int col = 1; col < N; col++) {
                if (array[row][col - 1] >= array[row][col]) {
                    return false;
                }
            }
        }

        for (int col = 0; col < N; col++) {
            for (int row = 1; row < N; row++) {
                if (array[row - 1][col] >= array[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] rotate90(int[][] array) {
        int[][] rotated = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                rotated[col][N - 1 - row] = array[row][col];
            }
        }

        return rotated;
    }

    private void printBoard(int[][] array) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                sb.append(array[row][col]);
                if (col != N - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}