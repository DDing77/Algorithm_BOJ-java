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
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        for (int bit = 0; bit < (1 << (N * M)); bit++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int temp = 0;
                for (int j = 0; j < M; j++) {
                    if ((bit & 1 << (i * M + j)) != 0) {
                        temp = temp * 10 + board[i][j];
                    } else {
                        sum += temp;
                        temp = 0;
                    }
                }
                sum += temp;
            }

            for (int j = 0; j < M; j++) {
                int temp = 0;
                for (int i = 0; i < N; i++) {
                    if ((bit & 1 << (i * M + j)) == 0) {
                        temp = temp * 10 + board[i][j];
                    } else {
                        sum += temp;
                        temp = 0;
                    }
                }
                sum += temp;
            }

            res = Math.max(res, sum);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
