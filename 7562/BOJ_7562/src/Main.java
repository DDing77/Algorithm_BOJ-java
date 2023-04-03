import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    private int T, N;
    private boolean[][] isVisited;

    public int bfs(int x, int y, int targetX, int targetY) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        que.add(0);
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();
            int cnt = que.poll();

            if (curX == targetX && curY == targetY) {
                return cnt;
            }

            for (int k = 0; k < 8; k++) {
                int nX = curX + dir[k][0];
                int nY = curY + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(nX);
                que.add(nY);
                que.add(cnt + 1);
                isVisited[nX][nY] = true;
            }
        }

        return 0;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            isVisited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            sb.append(bfs(startX, startY, targetX, targetY)).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
