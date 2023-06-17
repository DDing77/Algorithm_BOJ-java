import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int LENGTH = 200;
    static final int[][] dir = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static int N;
    static boolean[][] isVisited;
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int res;

    public static int execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y, 0});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < 6; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX > LENGTH || nY < 0 || nY > LENGTH) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (nX == r2 && nY == c2) {
                    return cur[2] + 1;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                isVisited[nX][nY] = true;
            }
        }

        return -1;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[LENGTH + 1][LENGTH + 1];

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        res = execBFS(r1, c1);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
