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
    private int K;
    private int[][] board;
    private boolean[][] isSelected;
    private int res;

    private void backTracking(int depth, int row, int col, int sum) {
        if (depth == K) {
            res = Math.max(res, sum);
            return;
        }

        int curX = row;
        int curY = col + 1;
        if (col + 1 >= M) {
            curX++;
            curY = 0;
        }

        for (int i = curX; i < N; i++) {
            for (int j = curY; j < M; j++) {
                if ((i - 1 >= 0 && isSelected[i - 1][j]) || (j - 1 >= 0 && isSelected[i][j - 1])) {
                    continue;
                }
                if (!isSelected[i][j]) {
                    isSelected[i][j] = true;
                    backTracking(depth + 1, i, j, sum + board[i][j]);
                    isSelected[i][j] = false;
                }
            }
            curY = 0;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isSelected = new boolean[N][M];
        res = Integer.MIN_VALUE;
        backTracking(0, 0, -1, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
