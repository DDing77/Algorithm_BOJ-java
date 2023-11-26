import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int R;
    int C;
    int[][] board;
    int res;

    public Pos getNextPos(int curX, int curY) {
        ArrayList<Pos> poses = new ArrayList<>();

        for (int i = 0; i < dir.length; i++) {
            int nX = curX + dir[i][0];
            int nY = curY + dir[i][1];

            if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                continue;
            }

            poses.add(new Pos(nX, nY, board[nX][nY]));
        }

        Collections.sort(poses);

        return poses.get(0);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = board[0][0];
        int curX = 0;
        int curY = 0;

        while (true) {
            if (curX == R - 1 && curY == C - 1) {
                break;
            }

            board[curX][curY] = 0;

            Pos nextPos = getNextPos(curX, curY);

            curX = nextPos.x;
            curY = nextPos.y;

            res += board[curX][curY];

        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static class Pos implements Comparable<Pos> {
        int x;
        int y;
        int value;

        public Pos(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Pos o) {
            return o.value - this.value;
        }
    }
}
