import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int C;
    private int[][] board;
    private boolean[] checked;
    private int res;

    private void backTracking(int depth, int sum) {

        if (depth == 11) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (board[depth][i] == 0 || checked[i]) {
                continue;
            }
            checked[i] = true;
            backTracking(depth + 1, sum + board[depth][i]);
            checked[i] = false;
        }
    }

    private void solution() throws IOException {

        C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            board = new int[11][11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            checked = new boolean[11];
            backTracking(0, 0);
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
