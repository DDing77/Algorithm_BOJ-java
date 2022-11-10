import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c, n;
    static char[][] map;
    static Queue<int[]> que = new LinkedList<>();

    static void bfs() {
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            map[curX][curY] = '.';

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                if (nX >= 0 && nX < r && nY >= 0 && nY < c) {
                    if (map[nX][nY] == 'O') {
                        map[nX][nY] = '.';
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                for (int k = 0; k < r; k++) {
                    for (int j = 0; j < c; j++) {
                        if (map[k][j] == 'O') {
                            que.add(new int[]{k, j});
                        }
                    }
                }
                for (char[] m : map) {
                    Arrays.fill(m, 'O');
                }
                bfs();
            }

        }

        if (n % 2 == 0) {
            for (char[] m : map) {
                Arrays.fill(m, 'O');
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}