import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int x, y, d;
    static int res;

    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void DFS(int r, int c, int dir) {
        if (map[r][c] == 1) return;
        else if (map[r][c] == 0) {
            map[r][c] = 2;
            res++;
        }

        int nextR, nextC;
        for (int d = 0; d < 4; d++) {
            dir = (dir + 3) % 4;
            nextR = r + dr[dir];
            nextC = c + dc[dir];

            if (map[nextR][nextC] == 1 || map[nextR][nextC] == 2) continue;

            DFS(nextR, nextC, dir);
            return;
        }

        DFS(r - dr[dir], c - dc[dir], dir);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        DFS(x, y, d);
        System.out.println(res);
    }
}
