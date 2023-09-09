import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{0, 1}, {1, 0}};
    int N;
    int[][] board;

    public boolean execBFS() {
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 2; i++) {
                int nX = cur[0] + board[cur[0]][cur[1]] * dir[i][0];
                int nY = cur[1] + board[cur[0]][cur[1]] * dir[i][1];

                if (nX == N - 1 && nY == N - 1) {
                    return true;
                }

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY});
            }
        }

        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (!execBFS()) {
            System.out.println("Hing");
        } else {
            System.out.println("HaruHaru");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
