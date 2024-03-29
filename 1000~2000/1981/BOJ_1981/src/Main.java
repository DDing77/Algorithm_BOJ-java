import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int[][] board;

    private boolean check(int min, int max, int mid) {

        for (int i = min; i + mid <= max; i++) {
            int start = i;
            int end = start + mid;

            if (start > board[0][0] || end < board[0][0]) {
                continue;
            }

            Queue<int[]> que = new ArrayDeque<>();
            boolean[][] isVisited = new boolean[N][N];
            que.add(new int[]{0, 0});
            isVisited[0][0] = true;

            while (!que.isEmpty()) {
                int[] cur = que.poll();

                if (cur[0] == N - 1 && cur[1] == N - 1) {
                    return true;
                }

                for (int k = 0; k < dir.length; k++) {
                    int nX = cur[0] + dir[k][0];
                    int nY = cur[1] + dir[k][1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }

                    if (isVisited[nX][nY]) {
                        continue;
                    }

                    if (start <= board[nX][nY] && board[nX][nY] <= end) {
                        que.add(new int[]{nX, nY});
                        isVisited[nX][nY] = true;
                    }
                }
            }
        }

        return false;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int min = 201;
        int max = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
                min = Math.min(min, board[i][j]);
            }
        }

        int left = -1;
        int right = max - min;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(min, max, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
