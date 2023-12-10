import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    char[][] board;
    int[][] cntBoard;
    int startX;
    int startY;
    int endX;
    int endY;
    int res;

    private void execBFS() {
        PriorityQueue<Cow> pq = new PriorityQueue<>();
        cntBoard[startX][startY] = 0;

        for (int i = 0; i < dir.length; i++) {
            int nX = startX + dir[i][0];
            int nY = startY + dir[i][1];

            if (isRange(nX, nY)) {
                pq.add(new Cow(nX, nY, i, 0));
                cntBoard[nX][nY] = 0;
            }
        }

        while (!pq.isEmpty()) {
            Cow cur = pq.poll();

            if (board[cur.x][cur.y] == 'B') {
                continue;
            }

            for (int i = 0; i < dir.length; i++) {
                int nextDirection = (cur.directionIdx + i) % dir.length;
                int nX = cur.x + dir[nextDirection][0];
                int nY = cur.y + dir[nextDirection][1];

                if (isRange(nX, nY)) {
                    int nextChangeDirectionCount = cur.changeDirectionCount;
                    if (nextDirection != cur.directionIdx) {
                        nextChangeDirectionCount++;
                    }

                    if (cntBoard[nX][nY] >= nextChangeDirectionCount) {
                        pq.add(new Cow(nX, nY, nextDirection, nextChangeDirectionCount));
                        cntBoard[nX][nY] = nextChangeDirectionCount;
                    }
                }
            }
        }
    }

    private boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && board[x][y] != 'x';
    }

    private void solution() {
        execBFS();
        System.out.println(cntBoard[endX][endY]);
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        startX = -1;
        startY = -1;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'A') {
                    startX = i;
                    startY = j;
                    continue;
                }
                if (board[i][j] == 'B') {
                    endX = i;
                    endY = j;
                }
            }
        }

        cntBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cntBoard[i], Integer.MAX_VALUE);
        }

        res = 0;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }

    static class Cow implements Comparable<Cow> {
        int x;
        int y;
        int directionIdx;
        int changeDirectionCount;

        public Cow(int x, int y, int directionIdx, int changeDirectionCount) {
            this.x = x;
            this.y = y;
            this.directionIdx = directionIdx;
            this.changeDirectionCount = changeDirectionCount;
        }

        @Override
        public int compareTo(Cow o) {
            return Integer.compare(this.changeDirectionCount, o.changeDirectionCount);
        }
    }
}
