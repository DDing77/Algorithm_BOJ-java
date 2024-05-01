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

    public static final int[][] dir = {{0, -1}, {1, 0}, {0, 1}};
    private int N;
    private int M;
    private char[][] board;
    private Queue<int[]> que;
    private boolean[][] isVisited;
    private int res;

    private void execBFS() {

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == N - 1) {
                res = cur[2];
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] != 'S') {
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

    private void solution() throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            board = new char[N][M];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    if (board[i][j] == 'S') {
                        if ((j == 0 || j == N - 1)) {
                            if (j < M - 2) {
                                board[i][j + 1] = 'S';
                                break;
                            }
                        } else {
                            if (j < M - 1) {
                                board[i][j + 1] = 'S';
                                break;
                            }
                        }
                    }
                }
            }

            que = new ArrayDeque<>();
            isVisited = new boolean[N][M];
            for (int i = 1; i < M - 1; i++) {
                if (board[0][i] == 'S') {
                    que.add(new int[]{0, i, 1});
                    isVisited[0][i] = true;
                }
            }

            execBFS();

            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
