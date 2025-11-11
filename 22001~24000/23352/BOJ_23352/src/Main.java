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

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int N;
    private int M;
    private int[][] board;
    private boolean[][] isVisited;
    private int resMaxDistance = -1;
    private int resMaxSum = 0;

    private void execBFS(int x, int y) {
        isVisited = new boolean[N][M];
        isVisited[x][y] = true;

        int sum = board[x][y] * 2;
        int distance = 0;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y, distance, sum});
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[2] > distance) {
                distance = cur[2];
                sum = cur[3];
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] == 0) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }

                int nextDistance = cur[2] + 1;
                int nextSum = board[x][y] + board[nX][nY];
                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY, nextDistance, nextSum});
            }
        }

        if (resMaxDistance < distance) {
            resMaxDistance = distance;
            resMaxSum = sum;
        } else if (resMaxDistance == distance) {
            resMaxSum = Math.max(resMaxSum, sum);
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    execBFS(i, j);
                }
            }
        }

        System.out.println(resMaxSum);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
