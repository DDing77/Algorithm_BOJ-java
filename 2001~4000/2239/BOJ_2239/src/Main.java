import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int[][] board;
    ArrayList<int[]> zeroLocation;
    boolean isFind;

    private boolean checkCross(int row, int col, int k) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k || board[i][col] == k) {
                return false;
            }
        }
        return true;
    }

    private boolean checkArea(int row, int col, int k) {
        int rowOffset = 3 * (row / 3);
        int colOffset = 3 * (col / 3);

        for (int i = rowOffset; i < rowOffset + 3; i++) {
            for (int j = colOffset; j < colOffset + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    private void backTracking(int depth) {

        if (depth == zeroLocation.size()) {
            isFind = true;
            return;
        }

        int row = zeroLocation.get(depth)[0];
        int col = zeroLocation.get(depth)[1];

        for (int k = 1; k <= 9; k++) {
            if (checkCross(row, col, k) && checkArea(row, col, k)) {
                board[row][col] = k;
                backTracking(depth + 1);
                if (isFind) {
                    return;
                }
                board[row][col] = 0;
            }
        }
    }

    private void solution() throws IOException {

        board = new int[9][9];
        zeroLocation = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = input.charAt(j) - '0';
                if (board[i][j] == 0) {
                    zeroLocation.add(new int[]{i, j});
                }
            }
        }

        isFind = false;
        backTracking(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
