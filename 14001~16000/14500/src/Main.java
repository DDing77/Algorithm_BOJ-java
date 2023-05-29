import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int res;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    // ㅓ ㅏ ㅗ ㅜ
    static int[][] exDirX = {{0, 1, 2, 1}, {0, 1, 2, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}};
    static int[][] exDirY = {{1, 1, 1, 0}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 2, 1}};

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            res = Math.max(res, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nX = x + dir[k][0];
            int nY = y + dir[k][1];

            if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
            if (isVisited[nX][nY]) continue;

            int newSum = sum + map[nX][nY];
            isVisited[nX][nY] = true;
            dfs(nX, nY, depth + 1, newSum);
            isVisited[nX][nY] = false;
        }
    }

    static void exceptionShape(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean isOut = false;
            for (int j = 0; j < 4; j++) {
                int nX = x + exDirX[i][j];
                int nY = y + exDirY[i][j];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) {
                    isOut = true;
                    continue;
                }
                sum += map[nX][nY];
            }
            if (!isOut) res = Math.max(res, sum);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                isVisited[i][j] = false;
                exceptionShape(i, j);
            }
        }

        System.out.println(res);
    }
}