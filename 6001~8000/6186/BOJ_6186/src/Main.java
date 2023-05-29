import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int R, C;
    private char[][] map;
    private boolean[][] isVisited;
    private int res;

    public void bfs(int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c});
        isVisited[r][c] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (map[nX][nY] != '#') {
                    continue;
                }

                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY});
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        res = 0;
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '#' && !isVisited[i][j]) {
                    res++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
