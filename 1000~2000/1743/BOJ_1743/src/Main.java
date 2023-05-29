import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N, M, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int cnt;

    public static void dfs(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nX = x + dir[k][0];
            int nY = y + dir[k][1];

            if (nX < 1 || nX > N || nY < 1 || nY > M) continue;
            if (map[nX][nY] != 1) continue;
            if (isVisited[nX][nY]) continue;
            cnt++;
            isVisited[nX][nY] = true;
            dfs(nX, nY);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    res = Math.max(res, cnt);
                }
            }
        }

        System.out.println(res);
    }
}
