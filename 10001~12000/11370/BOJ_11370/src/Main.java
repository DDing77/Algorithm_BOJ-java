import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int W;
    int H;
    char[][] board;
    boolean[][] isVisited;

    public void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < dir.length; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= H || nY < 0 || nY >= W) {
                    continue;
                }

                if (board[nX][nY] == 'T' && !isVisited[nX][nY]) {
                    que.add(new int[]{nX, nY});
                    board[nX][nY] = 'S';
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            board = new char[H][W];
            for (int i = 0; i < H; i++) {
                board[i] = br.readLine().toCharArray();
            }

            isVisited = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] == 'S' && !isVisited[i][j]) {
                        execBFS(i, j);
                    }
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(board[i][j]);
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
