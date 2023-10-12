import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int N;
    int M;
    int K;
    int[][] board;
    HashMap<Integer, Integer> groupHash;
    int groupNumber;
    int[][] groupBoard;
    int res;

    public boolean validateRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }

    public int getNextDirIdx(int bottom, int value, int dirIdx) {
        if (bottom > value) {
            return (dirIdx + 1) % 4;
        } else if (bottom < value) {
            dirIdx--;
            if (dirIdx < 0) {
                dirIdx = 3;
            }
            return dirIdx;
        }
        return dirIdx;
    }

    public int execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        groupBoard[x][y] = groupNumber;
        int value = board[x][y];

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (!validateRange(nX, nY)) {
                    continue;
                }

                if (board[nX][nY] == board[x][y] && groupBoard[nX][nY] == 0) {
                    que.add(new int[]{nX, nY});
                    groupBoard[nX][nY] = groupNumber;
                    value += board[nX][nY];
                }
            }
        }

        groupHash.put(groupNumber++, value);
        return value;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        groupNumber = 1;
        groupBoard = new int[N][M];
        groupHash = new HashMap<>();
        res = 0;
        Dice dice = new Dice();

        while (K-- > 0) {
            if (!validateRange(dice.x + dir[dice.dirIdx][0], dice.y + dir[dice.dirIdx][1])) {
                dice.dirIdx = (dice.dirIdx + 2) % 4;
            }

            dice.x = dice.x + dir[dice.dirIdx][0];
            dice.y = dice.y + dir[dice.dirIdx][1];

            dice.roll(dice.dirIdx);

            if (groupBoard[dice.x][dice.y] != 0) {
                res += groupHash.get(groupBoard[dice.x][dice.y]);
            } else {
                res += execBFS(dice.x, dice.y);
            }

            dice.dirIdx = getNextDirIdx(dice.bottom, board[dice.x][dice.y], dice.dirIdx);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Dice {
        int dirIdx;
        int x;
        int y;
        int top;
        int bottom;
        int left;
        int right;
        int up;
        int down;

        public Dice() {
            this.dirIdx = 0;
            this.x = 0;
            this.y = 0;
            this.top = 1;
            this.bottom = 6;
            this.left = 4;
            this.right = 3;
            this.up = 2;
            this.down = 5;
        }

        public void moveEast() {
            int temp = bottom;
            bottom = right;
            right = top;
            top = left;
            left = temp;
        }

        public void moveSouth() {
            int temp = bottom;
            bottom = down;
            down = top;
            top = up;
            up = temp;
        }

        public void moveWest() {
            int temp = bottom;
            bottom = left;
            left = top;
            top = right;
            right = temp;
        }

        public void moveNorth() {
            int temp = bottom;
            bottom = up;
            up = top;
            top = down;
            down = temp;
        }

        public void roll(int dirIdx) {
            if (dirIdx == 0) {
                moveEast();
            } else if (dirIdx == 1) {
                moveSouth();
            } else if (dirIdx == 2) {
                moveWest();
            } else {
                moveNorth();
            }
        }
    }
}
