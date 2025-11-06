import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int H;
    private int W;
    private int N;
    private char[][] board;
    private int res;

    private int[] bfsTo(int sx, int sy, char target) {
        boolean[][] visited = new boolean[H][W];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (board[x][y] == target) {
                return new int[]{d, x, y};
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 'X') continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, d + 1});
            }
        }
        return null;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[H][W];
        int sx = 0, sy = 0;
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        res = 0;
        int cx = sx, cy = sy;
        for (int k = 1; k <= N; k++) {
            char target = (char) ('0' + k);
            int[] response = bfsTo(cx, cy, target);
            res += response[0];
            cx = response[1];
            cy = response[2];
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
