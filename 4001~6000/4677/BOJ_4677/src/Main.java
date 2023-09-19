import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    int N;
    int M;
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

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == '*') {
                    continue;
                }

                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY});
            }
        }
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            board = new char[N][M];
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            isVisited = new boolean[N][M];
            res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == '@' && !isVisited[i][j]) {
                        res++;
                        execBFS(i, j);
                    }
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
