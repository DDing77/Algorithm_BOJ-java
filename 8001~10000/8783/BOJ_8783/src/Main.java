import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int T;
    int N;
    int M;
    char[][] board;
    int res;

    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        res--;
        board[0][0] = '#';

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N + 2 || nY < 0 || nY >= N + 2) {
                    continue;
                }
                if (board[nX][nY] == '#') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                board[nX][nY] = '#';
                res--;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            board = new char[N + 2][N + 2];
            for (int i = 1; i <= N; i++) {
                String input = br.readLine();
                for (int j = 1; j <= N; j++) {
                    board[i][j] = input.charAt(j - 1);
                }
            }

            res = (N + 2) * (N + 2);

            execBFS();

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
