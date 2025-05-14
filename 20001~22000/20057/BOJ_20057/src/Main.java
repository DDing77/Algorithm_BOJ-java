import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    private int N;
    private int[][] board;
    private int res;

    private boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private void blowLeft(int x, int y) {
        int temp = board[x][y];

        int type1 = (int) (temp * 0.01);
        if (!isRange(x - 1, y + 1)) {
            res += type1;
        } else {
            board[x - 1][y + 1] += type1;
        }

        if (!isRange(x + 1, y + 1)) {
            res += type1;
        } else {
            board[x + 1][y + 1] += type1;
        }

        int type2 = (int) (temp * 0.02);
        if (!isRange(x - 2, y)) {
            res += type2;
        } else {
            board[x - 2][y] += type2;
        }

        if (!isRange(x + 2, y)) {
            res += type2;
        } else {
            board[x + 2][y] += type2;
        }

        int type5 = (int) (temp * 0.05);
        if (!isRange(x, y - 2)) {
            res += type5;
        } else {
            board[x][y - 2] += type5;
        }

        int type7 = (int) (temp * 0.07);
        if (!isRange(x - 1, y)) {
            res += type7;
        } else {
            board[x - 1][y] += type7;
        }

        if (!isRange(x + 1, y)) {
            res += type7;
        } else {
            board[x + 1][y] += type7;
        }

        int type10 = (int) (temp * 0.1);
        if (!isRange(x - 1, y - 1)) {
            res += type10;
        } else {
            board[x - 1][y - 1] += type10;
        }

        if (!isRange(x + 1, y - 1)) {
            res += type10;
        } else {
            board[x + 1][y - 1] += type10;
        }

        board[x][y] = 0;
        int remain = temp - type1 * 2 - type2 * 2 - type5 - type7 * 2 - type10 * 2;

        if (!isRange(x, y - 1)) {
            res += remain;
        } else {
            board[x][y - 1] += remain;
        }
    }

    private void blowDown(int x, int y) {
        int temp = board[x][y];

        int type1 = (int) (temp * 0.01);
        if (!isRange(x - 1, y - 1)) {
            res += type1;
        } else {
            board[x - 1][y - 1] += type1;
        }

        if (!isRange(x - 1, y + 1)) {
            res += type1;
        } else {
            board[x - 1][y + 1] += type1;
        }

        int type2 = (int) (temp * 0.02);
        if (!isRange(x, y - 2)) {
            res += type2;
        } else {
            board[x][y - 2] += type2;
        }

        if (!isRange(x, y + 2)) {
            res += type2;
        } else {
            board[x][y + 2] += type2;
        }

        int type5 = (int) (temp * 0.05);
        if (!isRange(x + 2, y)) {
            res += type5;
        } else {
            board[x + 2][y] += type5;
        }

        int type7 = (int) (temp * 0.07);
        if (!isRange(x, y - 1)) {
            res += type7;
        } else {
            board[x][y - 1] += type7;
        }

        if (!isRange(x, y + 1)) {
            res += type7;
        } else {
            board[x][y + 1] += type7;
        }

        int type10 = (int) (temp * 0.1);
        if (!isRange(x + 1, y - 1)) {
            res += type10;
        } else {
            board[x + 1][y - 1] += type10;
        }

        if (!isRange(x + 1, y + 1)) {
            res += type10;
        } else {
            board[x + 1][y + 1] += type10;
        }

        board[x][y] = 0;
        int remain = temp - type1 * 2 - type2 * 2 - type5 - type7 * 2 - type10 * 2;

        if (!isRange(x + 1, y)) {
            res += remain;
        } else {
            board[x + 1][y] += remain;
        }
    }

    private void blowRight(int x, int y) {
        int temp = board[x][y];

        int type1 = (int) (temp * 0.01);
        if (!isRange(x - 1, y - 1)) {
            res += type1;
        } else {
            board[x - 1][y - 1] += type1;
        }

        if (!isRange(x + 1, y - 1)) {
            res += type1;
        } else {
            board[x + 1][y - 1] += type1;
        }

        int type2 = (int) (temp * 0.02);
        if (!isRange(x - 2, y)) {
            res += type2;
        } else {
            board[x - 2][y] += type2;
        }

        if (!isRange(x + 2, y)) {
            res += type2;
        } else {
            board[x + 2][y] += type2;
        }

        int type5 = (int) (temp * 0.05);
        if (!isRange(x, y + 2)) {
            res += type5;
        } else {
            board[x][y + 2] += type5;
        }

        int type7 = (int) (temp * 0.07);
        if (!isRange(x - 1, y)) {
            res += type7;
        } else {
            board[x - 1][y] += type7;
        }

        if (!isRange(x + 1, y)) {
            res += type7;
        } else {
            board[x + 1][y] += type7;
        }

        int type10 = (int) (temp * 0.1);
        if (!isRange(x - 1, y + 1)) {
            res += type10;
        } else {
            board[x - 1][y + 1] += type10;
        }

        if (!isRange(x + 1, y + 1)) {
            res += type10;
        } else {
            board[x + 1][y + 1] += type10;
        }

        board[x][y] = 0;
        int remain = temp - type1 * 2 - type2 * 2 - type5 - type7 * 2 - type10 * 2;
        if (!isRange(x, y + 1)) {
            res += remain;
        } else {
            board[x][y + 1] += remain;
        }
    }

    private void blowUp(int x, int y) {
        int temp = board[x][y];

        int type1 = (int) (temp * 0.01);
        if (!isRange(x + 1, y - 1)) {
            res += type1;
        } else {
            board[x + 1][y - 1] += type1;
        }

        if (!isRange(x + 1, y + 1)) {
            res += type1;
        } else {
            board[x + 1][y + 1] += type1;
        }

        int type2 = (int) (temp * 0.02);
        if (!isRange(x, y - 2)) {
            res += type2;
        } else {
            board[x][y - 2] += type2;
        }

        if (!isRange(x, y + 2)) {
            res += type2;
        } else {
            board[x][y + 2] += type2;
        }

        int type5 = (int) (temp * 0.05);
        if (!isRange(x - 2, y)) {
            res += type5;
        } else {
            board[x - 2][y] += type5;
        }

        int type7 = (int) (temp * 0.07);
        if (!isRange(x, y - 1)) {
            res += type7;
        } else {
            board[x][y - 1] += type7;
        }

        if (!isRange(x, y + 1)) {
            res += type7;
        } else {
            board[x][y + 1] += type7;
        }

        int type10 = (int) (temp * 0.1);
        if (!isRange(x - 1, y - 1)) {
            res += type10;
        } else {
            board[x - 1][y - 1] += type10;
        }

        if (!isRange(x - 1, y + 1)) {
            res += type10;
        } else {
            board[x - 1][y + 1] += type10;
        }

        board[x][y] = 0;
        int remain = temp - type1 * 2 - type2 * 2 - type5 - type7 * 2 - type10 * 2;
        if (!isRange(x - 1, y)) {
            res += remain;
        } else {
            board[x - 1][y] += remain;
        }
    }

    private void sandBlowing(int x, int y, int dir) {
        if (dir == 0) {
            blowLeft(x, y);
        } else if (dir == 1) {
            blowDown(x, y);
        } else if (dir == 2) {
            blowRight(x, y);
        } else if (dir == 3) {
            blowUp(x, y);
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tornadoX = N / 2;
        int tornadoY = N / 2;
        int tornadoDir = 0;
        int dist = 1;
        loop:
        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= dist; j++) {
                    tornadoX += dirs[tornadoDir][0];
                    tornadoY += dirs[tornadoDir][1];

                    sandBlowing(tornadoX, tornadoY, tornadoDir);

                    if (tornadoX == 0 && tornadoY == 0) {
                        break loop;
                    }
                }
                tornadoDir = (tornadoDir + 1) % 4;

            }
            dist++;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
