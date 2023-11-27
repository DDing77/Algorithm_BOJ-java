import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] board;
    int N;
    int find;

    public boolean changeDirection(int x, int y, int direction) {
        int nX = x + dir[direction][0];
        int nY = y + dir[direction][1];

        if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
            return true;
        }

        return board[nX][nY] != 0;
    }

    public void solution() {
        int curVal = N * N;
        int curX = 0;
        int curY = 0;
        int direction = 0;

        while (curVal > 0) {
            board[curX][curY] = curVal--;
            if (changeDirection(curX, curY, direction)) {
                direction = (direction + 1) % dir.length;
            }

            curX += dir[direction][0];
            curY += dir[direction][1];
        }

        StringBuilder sb = new StringBuilder();
        int findX = -1;
        int findY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(" ");
                if (board[i][j] == find) {
                    findX = i + 1;
                    findY = j + 1;
                }
            }
            sb.append('\n');
        }
        sb.append(findX).append(" ").append(findY);
        System.out.println(sb);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        find = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
