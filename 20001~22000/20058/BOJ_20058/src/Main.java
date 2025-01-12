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

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int Q;
    private int[][] board;
    private int L;
    private int resTotalIceValue;
    private int resBiggestIceSize;

    private int getLength(int exponent) {

        return (int) Math.pow(2, exponent);
    }

    private void rotate(int offsetX, int offsetY, int length) {

        int[][] temp = copy(offsetX, offsetY, length);

        for (int i = offsetX; i < offsetX + length; i++) {
            for (int j = offsetY; j < offsetY + length; j++) {
                board[i][j] = temp[i - offsetX][j - offsetY];
            }
        }
    }

    private void checkIce(int boardLength) {

        int[][] temp = new int[boardLength][boardLength];

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                int cnt = 0;
                for (int[] dir : dirs) {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];

                    if (nextX < 0 || nextX >= boardLength || nextY < 0 || nextY >= boardLength) {
                        continue;
                    }
                    if (board[nextX][nextY] == 0) {
                        continue;
                    }

                    cnt++;
                }

                temp[i][j] = board[i][j];
                if (cnt <  3) {
                    temp[i][j] = Math.max(0, temp[i][j] - 1);
                }
            }
        }

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                board[i][j] = temp[i][j];
            }
        }

    }

    private int[][] copy(int offsetX, int offsetY, int length) {

        int[][] temp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                temp[i][j] = board[offsetX + length - 1 - j][offsetY + i];
            }
        }
        return temp;
    }

    private void fireStorm(int length, int boardLength) {

        for (int i = 0; i < boardLength; i += length) {
            for (int j = 0; j < boardLength; j += length) {
                rotate(i, j, length);
            }
        }

        checkIce(boardLength);
    }

    private void getResult(int boardLength) {

        boolean[][] isVisited = new boolean[boardLength][boardLength];

        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (!isVisited[i][j] && board[i][j] != 0) {
                    execBFS(i, j, boardLength, isVisited);
                }
            }
        }
    }

    private void execBFS(int x, int y, int boardLength, boolean[][] isVisited) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        int cnt = 1;
        resTotalIceValue += board[x][y];

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];

                if (nextX < 0 || nextX >= boardLength || nextY < 0 || nextY >= boardLength) {
                    continue;
                }

                if (board[nextX][nextY] == 0) {
                    continue;
                }
                if (isVisited[nextX][nextY]) {
                    continue;
                }

                que.add(new int[]{nextX, nextY});
                isVisited[nextX][nextY] = true;
                cnt++;
                resTotalIceValue += board[nextX][nextY];
            }
        }

        resBiggestIceSize = Math.max(resBiggestIceSize, cnt);
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int boardLength = getLength(N);
        board = new int[boardLength][boardLength];

        for (int i = 0; i < boardLength; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < boardLength; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (Q-- > 0) {
            L = Integer.parseInt(st.nextToken());
            int length = getLength(L);

            fireStorm(length, boardLength);
        }

        getResult(boardLength);

        sb.append(resTotalIceValue).append("\n");
        sb.append(resBiggestIceSize);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
