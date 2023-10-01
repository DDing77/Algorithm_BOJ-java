import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-2, 1}, {-2, -1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {-1, -2}, {1, -2}};
    final int SIZE = 8;
    int startX;
    int startY;
    int endX;
    int endY;
    boolean[][] isVisited;
    int res;

    public void execBFS() {
        res = 0;
        isVisited = new boolean[SIZE][SIZE];
        isVisited[startX][startY] = true;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == endX && cur[1] == endY) {
                res = cur[2];
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= SIZE || nY < 0 || nY >= SIZE) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
