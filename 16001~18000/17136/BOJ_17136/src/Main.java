import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[] papers = {0, 5, 5, 5, 5, 5};

    private int[][] board;
    private int res;

    private void convert(int x, int y, int length, int type) {

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                board[i][j] = type;
            }
        }
    }

    private boolean check(int x, int y, int length) {

        if (x + length > 10 || y + length > 10) {
            return false;
        }

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private void backTracking(int idx, int count) {
//        System.out.println("count = " + count);
        if (idx == 100) {
//            System.out.println("Main.backTracking");
            res = Math.min(res, count);
            return;
        }

        int x = idx / 10;
        int y = idx % 10;
//        System.out.println("x = " + x + " y = " + y);
        if (board[x][y] == 0) {
            backTracking(idx + 1, count);
        } else {
            boolean flag = false;
            for (int i = 1; i <= 5; i++) {
                if (papers[i] > 0 && check(x, y, i)) {
                    convert(x, y, i, 0);
                    papers[i]--;
                    flag = true;
                    backTracking(idx + 1, count + 1);
                    convert(x, y, i, 1);
                    papers[i]++;
                }
            }

            if (!flag) {
                return;
            }
        }
    }

    private void solution() throws IOException {

        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 26;
        backTracking(0, 0);

        if (res == 26) {
            res = -1;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
