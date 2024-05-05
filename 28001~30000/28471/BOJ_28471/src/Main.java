import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    public static final int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, -1}, {0, -1}, {-1, -1}};
    private int N;
    private char[][] board;
    private int fX;
    private int fY;

    private int execBFS() {

        int count = 0;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{fX, fY});
        board[fX][fY] = '#';

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }
                if (board[nX][nY] != '.') {
                    continue;
                }

                board[nX][nY] = '#';
                count++;
                que.add(new int[]{nX, nY});
            }
        }
        return count;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);

                if (board[i][j] == 'F') {
                    fX = i;
                    fY = j;
                }
            }
        }

        System.out.println(execBFS());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
