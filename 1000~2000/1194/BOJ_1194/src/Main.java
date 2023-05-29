import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int x;
        int y;
        int bit;
        int cnt;

        public Info(int x, int y, int bit, int cnt) {
            this.x = x;
            this.y = y;
            this.bit = bit;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static char[][] map;
    static boolean[][][] isVisited;
    static int res;

    static void bfs(int startX, int startY, int bit, int cnt) {
        Queue<Info> que = new LinkedList<>();
        que.add(new Info(startX, startY, bit, cnt));
        isVisited[startX][startY][bit] = true;

        while (!que.isEmpty()) {
            Info cur = que.poll();

            if (map[cur.x][cur.y] == '1') {
                res = cur.cnt;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dx[k];
                int nY = cur.y + dy[k];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if (map[nX][nY] == '#' || isVisited[nX][nY][cur.bit]) continue;

                if (map[nX][nY] - 'a' >= 0 && map[nX][nY] - 'a' < 6) {
                    int tempKey = cur.bit | (1 << (map[nX][nY] - 'a'));
                    if (!isVisited[nX][nY][tempKey]) {
                        isVisited[nX][nY][tempKey] = true;
                        isVisited[nX][nY][cur.bit] = true;
                        que.add(new Info(nX, nY, tempKey, cur.cnt + 1));
                    }
                } else if (map[nX][nY] - 'A' >= 0 && map[nX][nY] - 'A' < 6) {
                    int tempDoor = (1 << (map[nX][nY] - 'A')) & cur.bit;
                    if (tempDoor > 0) {
                        isVisited[nX][nY][cur.bit] = true;
                        que.add(new Info(nX, nY, cur.bit, cur.cnt + 1));
                    }
                } else {
                    isVisited[nX][nY][cur.bit] = true;
                    que.add(new Info(nX, nY, cur.bit, cur.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M][(1 << 7)];

        int startX = -1;
        int startY = -1;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }

        res = -1;
        bfs(startX, startY, 0, 0);

        if (res == -1) System.out.println(-1);
        else System.out.println(res);
    }
}
