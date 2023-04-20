import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final int[][] generalDir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final int[][] horseDir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    private int K;
    private int W;
    private int H;
    private char[][] map;
    private boolean[][][] isVisited;
    private int res;

    private class Monkey {
        int x;
        int y;
        int movedCnt;
        int horseCnt;

        public Monkey(int x, int y, int movedCnt, int horseCnt) {
            this.x = x;
            this.y = y;
            this.movedCnt = movedCnt;
            this.horseCnt = horseCnt;
        }
    }

    public boolean isReach(int x, int y) {
        if (x < 0 || x >= H || y < 0 || y >= W) {
            return false;
        }

        return true;
    }

    public void execBFS() {
        isVisited = new boolean[H][W][K + 1];
        Queue<Monkey> que = new LinkedList<>();
        que.add(new Monkey(0, 0, 0, 0));
        isVisited[0][0][0] = true;

        while (!que.isEmpty()) {
            Monkey cur = que.poll();

            if (cur.x == H - 1 && cur.y == W - 1) {
                res = cur.movedCnt;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nX = cur.x + generalDir[k][0];
                int nY = cur.y + generalDir[k][1];

                if (!isReach(nX, nY)) {
                    continue;
                }

                if (isVisited[nX][nY][cur.horseCnt]) {
                    continue;
                }

                if (map[nX][nY] == '1') {
                    continue;
                }

                isVisited[nX][nY][cur.horseCnt] = true;
                que.add(new Monkey(nX, nY, cur.movedCnt + 1, cur.horseCnt));
            }

            if (cur.horseCnt + 1 > K) {
                continue;
            }

            for (int k = 0; k < 8; k++) {
                int nX = cur.x + horseDir[k][0];
                int nY = cur.y + horseDir[k][1];

                if (!isReach(nX, nY)) {
                    continue;
                }

                if (isVisited[nX][nY][cur.horseCnt + 1]) {
                    continue;
                }

                if (map[nX][nY] == '1') {
                    continue;
                }

                isVisited[nX][nY][cur.horseCnt + 1] = true;
                que.add(new Monkey(nX, nY, cur.movedCnt + 1, cur.horseCnt + 1));
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        res = -1;
        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
