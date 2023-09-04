import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int R;
    int C;
    int K;
    char[][] board;
    int res;

    public void execDFS(int depth, int x, int y, boolean[][] isVisited) {
        if (depth == K && x == 0 && y == C - 1) {
            res++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                continue;
            }

            if (isVisited[nX][nY]) {
                continue;
            }

            if (board[nX][nY] == 'T') {
                continue;
            }

            isVisited[nX][nY] = true;
            execDFS(depth + 1, nX, nY, isVisited);
            isVisited[nX][nY] = false;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = 0;
        boolean[][] isVisited = new boolean[R][C];
        isVisited[R - 1][0] = true;

        execDFS(1, R - 1, 0, isVisited);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
