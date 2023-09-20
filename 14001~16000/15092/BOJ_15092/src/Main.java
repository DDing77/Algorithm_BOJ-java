import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    int M;
    int N;
    char[][] board;
    boolean[][] isVisited;
    int res;

    public void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < dir.length; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= M || nY < 0 || nY >= N) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == '.') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[M][N];
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = 0;
        isVisited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '#' && !isVisited[i][j]) {
                    res++;
                    execBFS(i, j);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
