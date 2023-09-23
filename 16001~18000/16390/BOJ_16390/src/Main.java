import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    int m;
    int n;
    char[][] board;
    int res;

    public void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        board[x][y] = '.';

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < dir.length; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= m || nY < 0 || nY >= n) {
                    continue;
                }

                if (board[nX][nY] == '.') {
                    continue;
                }

                board[nX][nY] = '.';
                que.add(new int[]{nX, nY});
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    res++;
                    execBFS(i, j);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
