import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit = new boolean[12][6];
    static char[][] map = new char[12][6];
    static char[] c;
    static int grout_cnt, nx, ny, ans = 0;
    static boolean done;

    static void delete_dfs(int x, int y, char color) {
        for (int k = 0; k < 4; k++) {
            nx = x + dir[k][0];
            ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
            if (map[nx][ny] != color) continue;
            if (map[nx][ny] == color && visit[nx][ny] == true) {
                map[nx][ny] = '.';
                delete_dfs(nx, ny, color);
            }
        }
    }

    static void find_dfs(int x, int y, char color) {
        grout_cnt++;
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            nx = x + dir[k][0];
            ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
            if (map[nx][ny] != color) continue;
            if (visit[nx][ny]) continue;
            find_dfs(nx, ny, color);
        }
        if (grout_cnt >= 4) {
            delete_dfs(x, y, color);
            done = true;
        }
    }

    static void solution() {
        while (true) {
            done = false;
            visit = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visit[i][j] && map[i][j] != '.') {
                        char color = map[i][j];
                        grout_cnt = 0;
                        find_dfs(i, j, color);
                    }
                }
            }
            if (!done) break;
            ans++;
            while (true) {
                boolean check = false;
                check = down();
                if (!check) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }

    static boolean down() {
        boolean isDown = false;
        for (int i = 11; i > 0; i--) {
            for (int j = 5; j >= 0; j--) {
                if (map[i][j] == '.' && map[i - 1][j] != '.') {
                    map[i][j] = map[i - 1][j];
                    map[i - 1][j] = '.';
                    isDown = true;
                }
            }
        }
        if (!isDown) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            c = str.toCharArray();
            for (int j = 0; j < 6; j++) {
                map[i][j] = c[j];
            }
        }
        solution();
    }
}
