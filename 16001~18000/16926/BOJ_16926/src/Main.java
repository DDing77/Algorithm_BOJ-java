import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int R;
    int[][] board;

    private void rotate(int min) {

        int save;

        for (int i = 0; i < min; i++) {
            save = board[i][i];
            for (int j = i + 1; j < N - i; j++) {
                int temp = board[j][i];
                board[j][i] = save;
                save = temp;
            }

            for (int j = i + 1; j < M - i; j++) {
                int temp = board[N - i - 1][j];
                board[N - i - 1][j] = save;
                save = temp;
            }

            for (int j = N - i - 2; j >= i; j--) {
                int temp = board[j][M - i - 1];
                board[j][M - i - 1] = save;
                save = temp;
            }

            for (int j = M - i - 2; j >= i; j--) {
                int temp = board[i][j];
                board[i][j] = save;
                save = temp;
            }
        }
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

        int min = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            rotate(min);
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
