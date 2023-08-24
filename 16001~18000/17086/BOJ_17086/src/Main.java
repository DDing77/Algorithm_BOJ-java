import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    int N;
    int M;
    int[][] board;
    int[][] dist;
    Queue<Shark> sharks;
    int res;

    public void execBFS() {
        res = 0;
        dist = new int[N][M];

        while (!sharks.isEmpty()) {
            Shark cur = sharks.poll();

            for (int[] ints : dir) {
                int nX = cur.x + ints[0];
                int nY = cur.y + ints[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (dist[nX][nY] != 0 || board[nX][nY] == 1) {
                    continue;
                }

                dist[nX][nY] = dist[cur.x][cur.y] + 1;
                res = Math.max(res, dist[nX][nY]);
                sharks.add(new Shark(nX, nY));
            }

        }
        System.out.println(res);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        sharks = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    sharks.add(new Shark(i, j));
                }
            }
        }

        execBFS();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static class Shark {
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
