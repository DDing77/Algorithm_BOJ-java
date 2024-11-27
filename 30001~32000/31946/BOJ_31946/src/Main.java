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

    private int N;
    private int M;
    private int[][] board;
    private int X;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        X = Integer.parseInt(br.readLine());

        if (board[0][0] != board[N - 1][M - 1]) {
            System.out.println("DEAD");
            return;
        }

        boolean[][] isVisited = new boolean[N][M];
        isVisited[0][0] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        int base = board[0][0];

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = -X; i <= X; i++) {
                for (int j = -X; j <= X; j++) {
                    if (Math.abs(i) + Math.abs(j) > X) {
                        continue;
                    }

                    int nX = cur[0] + i;
                    int nY = cur[1] + j;

                    if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                        continue;
                    }
                    if (isVisited[nX][nY]) {
                        continue;
                    }
                    if (base != board[nX][nY]) {
                        continue;
                    }

                    if (nX == N - 1 && nY == M - 1) {
                        System.out.println("ALIVE");
                        return;
                    }

                    que.add(new int[]{nX, nY});
                    isVisited[nX][nY] = true;
                }
            }
        }

        System.out.println("DEAD");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
