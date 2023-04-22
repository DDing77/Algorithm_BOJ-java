import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* author : DDing77 */

public class Main {
    private final int[][] dirOdd = {{-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};
    private final int[][] dirEven = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {0, -1}};
    private int N;
    private int M;
    private char[][] map;
    private boolean[][] isVisited;
    private int res;

    public void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();

            for (int k = 0; k < 6; k++) {
                int nX;
                int nY;
                if ((curX + 1) % 2 == 1) {
                    nX = curX + dirOdd[k][0];
                    nY = curY + dirOdd[k][1];
                } else {
                    nX = curX + dirEven[k][0];
                    nY = curY + dirEven[k][1];
                }

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (map[nX][nY] == '.') {
                    res++;
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(nX);
                que.add(nY);
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        isVisited = new boolean[N][M];
        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] == '#') {

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
