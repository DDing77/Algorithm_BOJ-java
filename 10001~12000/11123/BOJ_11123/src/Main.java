import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int T;
    static int H;
    static int W;
    static char[][] map;
    static boolean[][] isVisited;
    static int res;

    public static void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= H || nY < 0 || nY >= W) {
                    continue;
                }

                if (map[nX][nY] == '.') {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            isVisited = new boolean[H][W];
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            res = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!isVisited[i][j] && map[i][j] == '#') {
                        res++;
                        execBFS(i, j);
                    }
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
