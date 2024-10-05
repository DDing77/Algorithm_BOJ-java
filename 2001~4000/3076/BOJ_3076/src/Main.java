import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int R;
    private int C;
    private int A;
    private int B;
    private char[][] board;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        board = new char[R * A][C * B];

        char ch;
        for (int i = 0; i < R; i++) {
            if (i % 2 == 0) {
                ch = 'X';
            } else {
                ch = '.';
            }
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < A; k++) {
                    for (int l = 0; l < B; l++) {
                        board[k + (A * i)][l + (B * j)] = ch;
                    }
                }
                if (ch == 'X') {
                    ch = '.';
                } else {
                    ch = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
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
