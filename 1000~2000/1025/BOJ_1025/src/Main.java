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

    private boolean check(int sum) {

        int sqrt = (int) Math.sqrt(sum);

        if (sqrt * sqrt == sum) {
            return true;
        }
        return false;
    }

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

//        res = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N; di < N; di++) {
                    for (int dj = -M; dj < M; dj++) {
                        if (di == 0 && dj == 0) {
                            continue;
                        }

                        int sum = 0;
                        int row = i;
                        int col = j;
                        while (0 <= row && row < N && 0 <= col && col < M) {
                            sum = sum * 10 + board[row][col];

                            if (check(sum)) {
                                res = Math.max(res, sum);
                            }

                            row += di;
                            col += dj;
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
