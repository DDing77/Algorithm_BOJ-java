import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private char[][] board;
    private boolean[] isVisited;
    private List<int[]> teachers;
    private boolean res;

    private boolean check() {

        int curX;
        int curY;
        int nX;
        int nY;
        for (int[] teacher : teachers) {
            for (int i = 0; i < dir.length; i++) {
                curX = teacher[0];
                curY = teacher[1];
                while ((0 <= curX + dir[i][0] && curX + dir[i][0] < N) && (0 <= curY + dir[i][1] && curY + dir[i][1] < N)) {
                    nX = curX + dir[i][0];
                    nY = curY + dir[i][1];
                    if (board[nX][nY] == 'S') {
                        return false;
                    } else if (board[nX][nY] == 'O' || board[nX][nY] == 'T') {
                        break;
                    }
                    curX = nX;
                    curY = nY;
                }
            }
        }
        return true;
    }

    private void backTracking(int idx, int depth) {

        if (res) {
            return;
        }

        if (depth == 3) {
            if (check()) {
                res = true;
            }
            return;
        }

        for (int i = idx; i < N * N; i++) {
            int x = i / N;
            int y = i % N;
            if (board[x][y] == 'X') {
                board[x][y] = 'O';
                backTracking(i + 1, depth + 1);
                board[x][y] = 'X';
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                }
            }
        }

        isVisited = new boolean[N * N];
        backTracking(0, 0);

        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
