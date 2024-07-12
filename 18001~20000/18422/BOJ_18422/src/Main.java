import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int N;
    private int M;
    private char[][] board;
    private int res;

    private void check(int x, int y) {

        int maxRow = x;
        int maxCol = y;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        board[x][y] = '-';
        int count = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] != '*') {
                    continue;
                }

                count++;
                board[nX][nY] = '-';
                maxRow = Math.max(maxRow, nX);
                maxCol = Math.max(maxCol, nY);
                que.add(new int[]{nX, nY});
            }
        }

        if (count == (maxRow - x + 1) * (maxCol - y + 1)) {
            res++;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '*') {
                    check(i, j);
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
