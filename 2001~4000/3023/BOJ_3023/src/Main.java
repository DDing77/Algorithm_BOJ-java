import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private char[][] board;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N * 2 + 1][M * 2 + 1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j + 1] = input.charAt(j);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2 * M; j > M; j--) {
                board[i][j] = board[i][2 * M - j + 1];
            }
        }

        for (int i = 2 * N; i > N; i--) {
            for (int j = 1; j <= 2 * M; j++) {
                board[i][j] = board[2 * N - i + 1][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (board[x][y] == '#') {
            board[x][y] = '.';
        } else {
            board[x][y] = '#';
        }

        for (int i = 1; i <= N * 2; i++) {
            for (int j = 1; j <= 2 * M; j++) {
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
