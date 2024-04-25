import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int R;
    private int C;
    private int T;
    private int[][] board;
    private int machineUpX;
    private int machineDownX;
    private int res;

    private void operateA(int[][] temp) {

        int curX = machineUpX;
        int curY = 0;

        int[][] operateADir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int dirIdx = 0;

        int total = C * 2 + ((machineUpX - 1) * 2);
        int pre = temp[curX][curY];
        int next;
        while (total > 0) {
            int nX = curX + operateADir[dirIdx % 4][0];
            int nY = curY + operateADir[dirIdx % 4][1];

            if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                dirIdx++;
                continue;
            }

            next = temp[nX][nY];
            temp[nX][nY] = pre;
            pre = next;
            total--;
            curX = nX;
            curY = nY;
        }
    }

    private void operateB(int[][] temp) {

        int curX = machineDownX;
        int curY = 0;

        int[][] operateADir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIdx = 0;

        int total = C * 2 + (R - machineDownX - 2) * 2;
        int pre = temp[curX][curY];
        int next;
        while (total > 0) {
            int nX = curX + operateADir[dirIdx % 4][0];
            int nY = curY + operateADir[dirIdx % 4][1];

            if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                dirIdx++;
                continue;
            }

            next = temp[nX][nY];
            temp[nX][nY] = pre;
            pre = next;
            total--;
            curX = nX;
            curY = nY;
        }
    }

    private void spread(int[][] temp) {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int x = i;
                int y = j;

                if (board[x][y] / 5 < 1) {
                    temp[x][y] += board[x][y];
                    continue;
                }

                int count = 0;
                for (int k = 0; k < dir.length; k++) {
                    int nX = x + dir[k][0];
                    int nY = y + dir[k][1];

                    if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                        continue;
                    }
                    if (board[nX][nY] == -1) {
                        continue;
                    }

                    count++;
                    temp[nX][nY] += (board[x][y] / 5);
                }
                temp[x][y] += board[x][y] - ((board[x][y] / 5) * count);
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        machineUpX = -1;
        machineDownX = -1;
        res = 0;

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    res += board[i][j];
                }
                if (board[i][j] == -1 && machineUpX == -1) {
                    machineUpX = i;
                } else if (board[i][j] == -1 && machineDownX == -1) {
                    machineDownX = i;
                }
            }
        }

        while (T-- > 0) {
            int[][] temp = new int[R][C];

            spread(temp);
            temp[machineUpX][0] = 0;
            temp[machineDownX][0] = 0;

            operateA(temp);
            operateB(temp);

            res -= temp[machineUpX][0];
            res -= temp[machineDownX][0];

            temp[machineUpX][0] = -1;
            temp[machineDownX][0] = -1;
            board = temp;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
