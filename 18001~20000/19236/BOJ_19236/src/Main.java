import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    private int[][] originBoard;
    private Fish[] originFish;
    private Fish shark;
    private int res;

    private boolean isSharkCanMove() {

        return false;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    private Fish[] copyFish(Fish[] fishes) {
        Fish[] newFish = new Fish[fishes.length];
        for (int i = 0; i < fishes.length; i++) {
            if (fishes[i] != null) {
                newFish[i] = fishes[i].copy();
            }
        }
        return newFish;
    }

    private boolean isRange(int x, int y) {
        if (x < 0 || x >= 4 || y < 0 || y >= 4) {
            return false;
        }
        return true;
    }

    private void moveFish(int[][] board, Fish[] fishes) {
        for (int i = 1; i <= 16; i++) {
            if (fishes[i] == null) {
                continue;
            }

            int curX = fishes[i].x;
            int curY = fishes[i].y;
            int dirIdx = fishes[i].dirIdx;

            for (int rot = 0; rot < 7; rot++) {
                int nX = curX + dirs[dirIdx][0];
                int nY = curY + dirs[dirIdx][1];

                if (isRange(nX, nY) && board[nX][nY] != 0) {
                    int targetId = board[nX][nY];

                    board[curX][curY] = targetId;
                    board[nX][nY] = i;

                    fishes[i].x = nX;
                    fishes[i].y = nY;

                    if (targetId != -1) {
                        fishes[targetId].x = curX;
                        fishes[targetId].y = curY;
                    }

                    fishes[i].dirIdx = dirIdx;
                    break;
                }

                dirIdx = (dirIdx + 1) % 8;
            }
        }
    }

    private void backTracking(int[][] board, Fish[] fishes, int sum) {
        res = Math.max(res, sum);

        moveFish(board, fishes);

        int sharkX = fishes[0].x;
        int sharkY = fishes[0].y;
        int dirIdx = fishes[0].dirIdx;

        for (int step = 1; step <= 3; step++) {
            int nX = sharkX + dirs[dirIdx][0] * step;
            int nY = sharkY + dirs[dirIdx][1] * step;

            if (!isRange(nX, nY)) {
                break;
            }

            if (board[nX][nY] == -1) {
                continue;
            }

            int[][] copiedBoard = copyBoard(board);
            Fish[] copiedFish = copyFish(fishes);

            int targetId = copiedBoard[nX][nY];

            copiedBoard[sharkX][sharkY] = -1;
            copiedBoard[nX][nY] = 0;

            copiedFish[0].x = nX;
            copiedFish[0].y = nY;
            copiedFish[0].dirIdx = copiedFish[targetId].dirIdx;

            int nextSum = sum + copiedFish[targetId].fishId;
            copiedFish[targetId] = null;

            backTracking(copiedBoard, copiedFish, nextSum);
        }
    }


    private void solution() throws IOException {
        originBoard = new int[4][4];
        originFish = new Fish[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int fishId = Integer.parseInt(st.nextToken());
                int dirIdx = Integer.parseInt(st.nextToken()) - 1;
                Fish fish = new Fish(fishId, i, j, dirIdx);
                originFish[fishId] = fish;
                originBoard[i][j] = fishId;
            }
        }

        originFish[0] = new Fish(0, 0, 0, originFish[originBoard[0][0]].dirIdx);
        originFish[0].isShark = true;
        res += originFish[originBoard[0][0]].fishId;
        originFish[originBoard[0][0]] = null;
        originBoard[0][0] = 0;
        backTracking(originBoard, originFish, res);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Fish {

        int fishId;
        int x;
        int y;
        int dirIdx;
        boolean isShark = false;

        public Fish(int fishId, int x, int y, int dirIdx) {
            this.fishId = fishId;
            this.x = x;
            this.y = y;
            this.dirIdx = dirIdx;
        }

        public Fish copy() {
            return new Fish(fishId, x, y, dirIdx);
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "fishId=" + fishId +
                    ", x=" + x +
                    ", y=" + y +
                    ", dirIdx=" + dirIdx +
                    '}';
        }
    }
}
