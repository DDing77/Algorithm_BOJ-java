import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int res;

    static void bfs(int x, int y, int height) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = curX + dir[k][0];
                int nY = curY + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                if (isVisited[nX][nY]) continue;
                if (map[nX][nY] <= height) continue;

                isVisited[nX][nY] = true;
                que.add(nX);
                que.add(nY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        res = 0;
        for (int height = 0; height < max; height++) {
            int cnt = 0;
            isVisited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j] && map[i][j] > height) {
                        bfs(i, j, height);
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        System.out.println(res);
    }
}
