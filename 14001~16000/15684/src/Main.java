import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][] map;
    static int res;
    static boolean flag;

    static boolean check() {

        for (int i = 1; i <= N; i++) {
            int curColumn = i;
            int curHeight = 1;

            while (curHeight <= H) {
                if (map[curHeight][curColumn] == 1) {
                    curColumn++;
                } else if (map[curHeight][curColumn] == 2) {
                    curColumn--;
                }
                curHeight++;
            }
            if (curColumn != i) return false;
        }
        return true;
    }

    static void dfs(int x, int y, int cnt) {

        if (cnt == res) {
            if (check()) flag = true;
            return;
        }

        for (int i = y; i <= H; i++) {
            for (int j = x; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;

                    dfs(1, 1, cnt + 1);

                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[height][col] = 1;
            map[height][col + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            flag = false;
            res = i;
            dfs(1, 1, 0);
            if (flag) break;
        }

        if (!flag) System.out.println(-1);
        else System.out.println(res);
    }
}