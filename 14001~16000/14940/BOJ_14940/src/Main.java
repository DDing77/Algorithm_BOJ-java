import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n;
    static int m;
    static int[][] distance;
    static ArrayDeque<int[]> que;

    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        n = readInt();
        m = readInt();

        distance = new int[n][m];
        que = new ArrayDeque<>();

        int cur;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cur = readInt();
                if (cur != 0) {
                    distance[i][j] = -1;
                } else {
                    distance[i][j] = -2;
                }

                if (cur == 2) {
                    que.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            int[] curQue = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = curQue[0] + dir[k][0];
                int nY = curQue[1] + dir[k][1];

                if (nX < 0 || nX >= n || nY < 0 || nY >= m) {
                    continue;
                }

                if (distance[nX][nY] >= 0 || distance[nX][nY] == -2) {
                    continue;
                }

                distance[nX][nY] = distance[curQue[0]][curQue[1]] + 1;

                que.offer(new int[]{nX, nY});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (distance[i][j] == -2) {
                    sb.append(0 + " ");
                    continue;
                }
                sb.append(distance[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
