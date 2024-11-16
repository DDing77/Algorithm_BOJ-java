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

    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int R;
    private int C;
    private char[][] board;
    private boolean res;

    private void execBFS(int x, int y) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});

        boolean[][] isVisited = new boolean[R][C];
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int count = 0;
            for (int k = 0; k < dir.length; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }

                if (board[nX][nY] == 'X') {
                    continue;
                }

                count++;

                if (!isVisited[nX][nY]) {
                    isVisited[nX][nY] = true;
                    que.add(new int[]{nX, nY});
                }
            }

            if (count < 2) {
                res = true;
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '.') {
                    execBFS(i, j);
                }
            }
        }

        if (res) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
