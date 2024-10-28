import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[][] board;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            board[i][i] = 1;
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from][to] = 1;
            board[to][from] = -1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                    } else if (board[i][k] == -1 && board[k][j] == -1) {
                        board[i][j] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (board[i][j] == 1 || board[i][j] == -1) {
                    count++;
                }
            }
            sb.append(N - count - 1).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
