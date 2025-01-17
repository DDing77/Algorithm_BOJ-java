import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int W;
    private int H;
    private int[][] board;
    private boolean[][] isVisited;
    private int res;

    private void execDFS(int x, int y) {

        if (x < 0 || x >= H + 2 || y < 0 || y >= W + 2) {
            return;
        }

        if (board[x][y] == 1) {
            res++;
            return;
        }


        if (board[x][y] == 0 && !isVisited[x][y]) {
            isVisited[x][y] = true;

            execDFS(x, y - 1);
            execDFS(x, y + 1);
            execDFS(x - 1, y);
            execDFS(x + 1, y);
            if (x % 2 == 1) {
                execDFS(x - 1, y + 1);
                execDFS(x + 1, y + 1);
            } else {
                execDFS(x - 1, y - 1);
                execDFS(x + 1, y - 1);
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H + 2][W + 2];
        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[H + 2][W + 2];
        execDFS(0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
