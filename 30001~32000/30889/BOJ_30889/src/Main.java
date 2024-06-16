import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[][] board;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[10][20];

        for (int i = 0; i < N; i++) {
            String seat = br.readLine();
            int line = seat.charAt(0) - 'A';
            int number = Integer.parseInt(seat.substring(1)) - 1;
            board[line][number] = 'o';
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'o') {
                    sb.append('.');
                } else {
                    sb.append(board[i][j]);
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
