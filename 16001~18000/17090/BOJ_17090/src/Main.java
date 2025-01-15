import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private char[][] board;
    private int[][] logs;
    private int res;

    private int execDFS(int x, int y) {

        logs[x][y] = -1;

        int nextX = x + dir[board[x][y]][0];
        int nextY = y + dir[board[x][y]][1];

        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
            return logs[x][y] = 1;
        }

        if (logs[nextX][nextY] != 0) {
            return logs[x][y] = logs[nextX][nextY];
        }

        return logs[x][y] = execDFS(nextX, nextY);
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'U') {
                    board[i][j] = 0;
                } else if (input.charAt(j) == 'D') {
                    board[i][j] = 1;
                } else if (input.charAt(j) == 'L') {
                    board[i][j] = 2;
                } else if (input.charAt(j) == 'R') {
                    board[i][j] = 3;
                }
            }
        }

        logs = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
               if (logs[i][j] == 0) {
                   execDFS(i, j);
               }
               if (logs[i][j] == 1) {
                   res++;
               }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
