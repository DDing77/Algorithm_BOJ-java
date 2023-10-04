import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int SIZE = 500;
    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int x;
    int y;
    int N;
    boolean[][] board;
    int res;

    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{SIZE, SIZE, 0});
        board[SIZE][SIZE] = true;
        res = -1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == x && cur[1] == y) {
                res = cur[2];
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX > SIZE * 2 || nY < 0 || nY > SIZE * 2) {
                    continue;
                }
                if (board[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                board[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) + SIZE;
        y = Integer.parseInt(st.nextToken()) + SIZE;
        N = Integer.parseInt(st.nextToken());

        board = new boolean[SIZE * 2 + 1][SIZE * 2 + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken()) + SIZE][Integer.parseInt(st.nextToken()) + SIZE] = true;
        }

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
