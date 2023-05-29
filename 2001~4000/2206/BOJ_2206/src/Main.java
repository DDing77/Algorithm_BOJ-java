import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int x;
        int y;
        boolean isBreak;

        public Info(int x, int y, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.isBreak = isBreak;
        }
    }

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M;
    static int res;
    static int[][] map;
    static int[][] cnt;
    static boolean[][][] isVisited;

    static void bfs() {
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(1, 1, false));
        cnt[1][1] = 1;
        isVisited[1][1][0] = true;

        while (!que.isEmpty()) {
            Info cur = que.poll();

            if (cur.x == N && cur.y == M) return;

            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dir[k][0];
                int nY = cur.y + dir[k][1];

                if (nX <= 0 || nX > N || nY <= 0 || nY > M) continue;

                if (map[nX][nY] == 0) {
                    if (!cur.isBreak && !isVisited[nX][nY][0]) {
                        isVisited[nX][nY][0] = true;
                        que.add(new Info(nX, nY, false));
                    } else if (cur.isBreak && !isVisited[nX][nY][1]) {
                        isVisited[nX][nY][1] = true;
                        que.add(new Info(nX, nY, true));
                    }
                } else {
                    if (!cur.isBreak) {
                        que.add(new Info(nX, nY, true));
                        cnt[nX][nY] = cnt[cur.x][cur.y] + 1;
                        isVisited[nX][nY][1] = true;
                    }
                }
                cnt[nX][nY] = cnt[cur.x][cur.y] + 1;

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        cnt = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j - 1)));
        }

        res = -1;
        bfs();

        if (cnt[N][M] != 0) res = cnt[N][M];

        System.out.println(res);
    }
}
