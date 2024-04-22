import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int[][] board;
    boolean[][] isVisited;
    int minRes;

    private boolean check(int x, int y) {

        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (isVisited[nX][nY]) {
                return true;
            }
        }
        return false;
    }

    private int visitAndSum(int x, int y) {

        int sum = 0;
        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            isVisited[nX][nY] = true;
            sum += board[nX][nY];
        }
        return sum;
    }

    private void backTracking(int depth, int sum) {

        if (depth == 3) {
            minRes = Math.min(minRes, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (check(i, j)) {
                    continue;
                }
                int nextSum = visitAndSum(i, j);

                backTracking(depth + 1, sum + nextSum);

                for (int k = 0; k < dir.length; k++) {
                    int nX = i + dir[k][0];
                    int nY = j + dir[k][1];

                    isVisited[nX][nY] = false;
                }
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[N][N];
        minRes = Integer.MAX_VALUE;
        backTracking(0, 0);

        System.out.println(minRes);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
