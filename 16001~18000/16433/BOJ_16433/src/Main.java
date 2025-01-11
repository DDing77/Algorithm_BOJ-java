import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    private int N;
    private int R;
    private int C;
    private char[][] board;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }

        board[R][C] = 'v';

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{R, C});
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }
                if (board[nX][nY] == 'v') {
                    continue;
                }

                board[nX][nY] = 'v';
                que.add(new int[]{nX, nY});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
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
