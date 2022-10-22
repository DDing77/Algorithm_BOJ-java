import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int w, h;
    static int[][] map;
    static boolean[][] isVisited;
    static int res;

    static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();

            for (int k = 0; k < 8; k++) {
                int nX = curX + dir[k][0];
                int nY = curY + dir[k][1];

                if (nX < 0 || nX >= h || nY < 0 || nY >= w) continue;
                if (map[nX][nY] == 0) continue;
                if (isVisited[nX][nY]) continue;

                que.add(nX);
                que.add(nY);
                isVisited[nX][nY] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            isVisited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !isVisited[i][j]) {
                        res++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
