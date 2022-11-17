import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Hero {
        int r;
        int c;
        int time;
        int sword;

        public Hero(int r, int c, int time, int sword) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.sword = sword;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getTime() {
            return time;
        }

        public int isSword() {
            return sword;
        }
    }

    static final int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M, T;
    static int[][] map;
    static boolean[][][] isVisited;
    static int res;

    static void bfs(int startX, int startY, int hasSword) {
        Queue<Hero> que = new LinkedList<>();
        que.add(new Hero(startX, startY, 0, hasSword));
        isVisited[0][0][0] = true;

        while (!que.isEmpty()) {
            Hero cur = que.poll();
            if (cur.getTime() > T) continue;
            if (cur.getR() == N - 1 && cur.getC() == M - 1) {
                res = cur.getTime();
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nX = cur.getR() + dir[k][0];
                int nY = cur.getC() + dir[k][1];
                int nTime = cur.getTime() + 1;
                int isSword = cur.isSword();

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) continue;

                if (isSword == 0) {
                    if (isVisited[nX][nY][0]) continue;
                    if (map[nX][nY] == 1) continue;
                    if (map[nX][nY] == 2) isSword = 1;
                } else {
                    if (isVisited[nX][nY][1]) continue;
                }

                isVisited[nX][nY][isSword] = true;
                que.add(new Hero(nX, nY, nTime, isSword));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N][M][2];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sword = 0;
        if (map[0][0] == 2) sword = 1;

        res = -1;
        bfs(0, 0, sword);

        if (res == -1) {
            System.out.println("Fail");
            return;
        }

        System.out.println(res);
    }
}
