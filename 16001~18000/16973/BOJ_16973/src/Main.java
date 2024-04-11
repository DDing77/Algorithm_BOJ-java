import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int M;
    int[][] board;
    int H;
    int W;
    int r1;
    int c1;
    int r2;
    int c2;

    private void update(int r, int c) {
        while (r <= N) {
            int cc = c;
            while (cc <= M) {
                board[r][cc] += 1;
                cc += cc & -cc;
            }
            r += r & -r;
        }
    }

    private int getPrefixSum(int r, int c) {
        int sum = 0;
        while (r > 0) {
            int cc = c;
            while (cc > 0) {
                sum += board[r][cc];
                cc -= cc & -cc;
            }
            r -= r & -r;
        }
        return sum;
    }

    private boolean rangeCheck(int x1, int y1, int x2, int y2) {
        if (x1 <= 0 || x1 > N || y1 <= 0 || y1 > M) {
            return false;
        }
        if (x2 <= 0 || x2 > N || y2 <= 0 || y2 > M) {
            return false;
        }
        return true;
    }

    private int execBFS(int x, int y) {
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y, 0});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == r2 && cur[1] == c2) {
                return cur[2];
            }

            for (int i = 0; i < dir.length; i++) {
                int nX1 = cur[0] + dir[i][0];
                int nY1 = cur[1] + dir[i][1];
                int nX2 = nX1 + H - 1;
                int nY2 = nY1 + W - 1;

                if (!rangeCheck(nX1, nY1, nX2, nY2)) {
                    continue;
                }

                if (isVisited[nX1][nY1]) {
                    continue;
                }

                int obstacleCount = getPrefixSum(nX2, nY2) - getPrefixSum(nX2, nY1 - 1) - getPrefixSum(nX1 - 1, nY2) + getPrefixSum(nX1 - 1, nY1 - 1);
                if (obstacleCount > 0) {
                    continue;
                }

                que.add(new int[]{nX1, nY1, cur[2] + 1});
                isVisited[nX1][nY1] = true;
            }
        }

        return -1;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                if (st.nextToken().equals("1")) {
                    update(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        System.out.println(execBFS(r1, c1));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
