import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[][] board;

    private void solution() throws IOException {

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            char[] input = br.readLine().toCharArray();
            int rowSize = input.length / N;
            board = new char[rowSize][N];

            int dir = 1;
            int count = 0;
            int row = 0;
            for (int i = 0; i < input.length; i++) {
                if (dir == 1) {
                    board[row][count] = input[i];
                } else {
                    board[row][N - count - 1] = input[i];
                }

                count++;
                if (count % N == 0) {
                    dir *= -1;
                    row++;
                    count = 0;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < rowSize; j++) {
                    sb.append(board[j][i]);
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
