import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n, m;
    private int[][] map;
    private boolean[][] isVisited;
    private int resCnt;
    private int resMaxSize;

    public int execBFS(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        int size = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= n || nY < 0 || nY >= m) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (map[nX][nY] != 1) {
                    continue;
                }

                size++;
                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }

        return size;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        resCnt = 0;
        resMaxSize = 0;
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    resCnt++;
                    resMaxSize = Math.max(resMaxSize, execBFS(i, j));
                }
            }
        }

        sb.append(resCnt).append('\n').append(resMaxSize);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
