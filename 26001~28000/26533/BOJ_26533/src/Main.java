import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    final int[][] dir = {{1, 0}, {0, 1}};
    int N;
    char[][] board;

    public boolean execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        board[0][0] = 'x';

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == N - 1 && cur[1] == N - 1) {
                return true;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }
                if (board[nX][nY] == 'x') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                board[nX][nY] = 'x';
            }
        }
        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (board[0][0] == 'x' || board[N - 1][N - 1] == 'x') {
            System.out.println("No");
            return;
        }

        if (execBFS()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
