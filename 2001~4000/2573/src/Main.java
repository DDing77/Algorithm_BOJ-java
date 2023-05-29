import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class IceBerg {
        int x;
        int y;

        public IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static int ans, cnt;

    static void melting() {
        boolean[][] melted = new boolean[N][M];
        Queue<IceBerg> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    que.add(new IceBerg(i, j));
                    melted[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            IceBerg cur = que.poll();
            int sea = 0;
            for (int k = 0; k < 4; k++) {
                int newX = cur.x + dX[k];
                int newY = cur.y + dY[k];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if (melted[newX][newY]) continue;
                if (map[newX][newY] == 0) sea++;
            }

            map[cur.x][cur.y] -= sea;
            if (map[cur.x][cur.y] < 0) map[cur.x][cur.y] = 0;
        }
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int newX = x + dX[k];
            int newY = y + dY[k];

            if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
            if (isVisited[newX][newY]) continue;
            if (map[newX][newY] != 0) dfs(newX, newY);
        }
    }

    static int getIceBergCnt() {
        isVisited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        cnt = getIceBergCnt();

        while (cnt < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            melting();
            ans++;
            cnt = getIceBergCnt();
        }

        System.out.println(ans);
    }
}