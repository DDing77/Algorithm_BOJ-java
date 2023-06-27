import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R;
    static int C;
    static int res;
    static char map[][];
    static Queue<Info> fire;
    static Queue<Info> jh;

    public static boolean execBFS() {

        while (!jh.isEmpty()) {

            // 불이 먼저 퍼진다.
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Info cur = fire.poll();

                for (int k = 0; k < 4; k++) {
                    int nX = cur.x + dir[k][0];
                    int nY = cur.y + dir[k][1];

                    if (nX < 0 || nY < 0 || nX >= R || nY >= C) {
                        continue;
                    }

                    if (map[nX][nY] == '#') {
                        continue;
                    }

                    if (map[nX][nY] == 'F') {
                        continue;
                    }

                    map[nX][nY] = 'F';
                    fire.add(new Info(nX, nY, cur.d + 1));
                }
            }

            size = jh.size();
            for (int i = 0; i < size; i++) {
                Info cur = jh.poll();

                for (int k = 0; k < 4; k++) {
                    int nX = cur.x + dir[k][0];
                    int nY = cur.y + dir[k][1];

                    if (nX < 0 || nY < 0 || nX >= R || nY >= C) {
                        res = cur.d + 1;
                        return true;
                    }

                    if (map[nX][nY] == '.') {
                        map[nX][nY] = 'J';
                        jh.add(new Info(nX, nY, cur.d + 1));
                    }

                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        fire = new ArrayDeque<>();
        jh = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    jh.add(new Info(i, j, 0));
                } else if (map[i][j] == 'F') {
                    fire.add(new Info(i, j, 0));
                }
            }
        }

        if (execBFS()) {
            System.out.println(res);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    static class Info {
        int x;
        int y;
        int d;

        public Info(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}