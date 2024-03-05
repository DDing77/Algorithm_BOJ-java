import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;
    char[][] board;

    private void dq(int N, int top, int bottom, int length, int distance) {

        if (N == 1) {
            return;
        }

        if (distance != 0) {
            board[top][length + 1] = '*';
        }

        if (N == 2) {
            board[top + 2][length - 1] = '*';
            board[top + 2][length - 2] = '*';
            board[top + 3][length - 2] = '*';
            board[top + 4][length - 2] = '*';
        }

        board[top + 1][distance] = '*';

        for (int i = distance; i <= length; i++) {
            board[top][i] = '*';
            board[bottom][i] = '*';
        }

        for (int i = distance + 2; i <= bottom; i++) {
            board[i][distance] = '*';
            board[i][length] = '*';
        }


        dq(N - 1, top + 2, bottom - 2, length - 2, distance + 2);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("*");
            return;
        } else {
            board = new char[4 * N - 1][4 * N - 3];
        }

        dq(N, 0, board.length - 1, board[0].length - 1, 0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 1 && j == 0) {
                    sb.append(board[i][j]);
                    break;
                }
                if (board[i][j] == '*') {
                    sb.append('*');
                } else {
                    sb.append(" ");
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
