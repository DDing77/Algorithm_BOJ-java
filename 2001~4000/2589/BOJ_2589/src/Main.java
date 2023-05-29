import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R, C;
    static int[][] dp;
    static char[][] map;
    static int max;

    static void bfs(int startX, int startY) {
        dp = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(dp[i], -1);

        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);
        dp[startX][startY] = 0;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = curX + dir[k][0];
                int nY = curY + dir[k][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) continue;

                if (map[nX][nY] == 'W') continue;
                if (dp[nX][nY] != -1) continue;

                dp[nX][nY] = dp[curX][curY] + 1;
                max = Math.max(max, dp[nX][nY]);
                que.add(nX);
                que.add(nY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dp = new int[R][C];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);
    }
}
