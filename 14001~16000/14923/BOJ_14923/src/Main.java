import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private int Hx;
    private int Hy;
    private int Ex;
    private int Ey;
    private int[][] board;
    private boolean[][][] isVisited;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken());
        Hy = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken());
        Ey = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[N + 1][M + 1][2];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{Hx, Hy, 0, 0});
        isVisited[Hx][Hy][0] = true;
        res = -1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == Ex && cur[1] == Ey) {
                res = cur[2];
                break;
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX <= 0 || nX > N || nY <= 0 || nY > M) {
                    continue;
                }
                if (isVisited[nX][nY][cur[3]]) {
                    continue;
                }

                if (cur[3] == 0) {
                    int nextStatus = cur[3];
                    if (board[nX][nY] == 1) {
                        nextStatus++;
                    }
                    que.add(new int[]{nX, nY, cur[2] + 1, nextStatus});
                    isVisited[nX][nY][nextStatus] = true;
                } else if (cur[3] == 1) {
                    if (board[nX][nY] == 0) {
                        que.add(new int[]{nX, nY, cur[2] + 1, cur[3]});
                        isVisited[nX][nY][cur[3]] = true;
                    }
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
