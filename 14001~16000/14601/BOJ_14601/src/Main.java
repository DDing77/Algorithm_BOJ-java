import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int K;
    int[][] board;
    int blockNum;

    private boolean preBlockCheck(int rowOffset, int colOffset, int length) {

        for (int i = rowOffset; i < rowOffset + length; i++) {
            for (int j = colOffset; j < colOffset + length; j++) {
                if (board[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private void makeBoardTable(int rowOffset, int colOffset, int length) {

        blockNum++;

        int nextLength = length >> 1;
        if (preBlockCheck(rowOffset, colOffset, nextLength)) {
            board[rowOffset + nextLength - 1][colOffset + nextLength - 1] = blockNum;
        }
        if (preBlockCheck(rowOffset + nextLength, colOffset, nextLength)) {
            board[rowOffset + nextLength][colOffset + nextLength - 1] = blockNum;
        }
        if (preBlockCheck(rowOffset, colOffset + nextLength, nextLength)) {
            board[rowOffset + nextLength - 1][colOffset + nextLength] = blockNum;
        }
        if (preBlockCheck(rowOffset + nextLength, colOffset + nextLength, nextLength)) {
            board[rowOffset + nextLength][colOffset + nextLength] = blockNum;
        }

        if (length == 2) {
            return;
        }

        makeBoardTable(rowOffset, colOffset, nextLength);
        makeBoardTable(rowOffset + nextLength, colOffset, nextLength);
        makeBoardTable(rowOffset, colOffset + nextLength, nextLength);
        makeBoardTable(rowOffset + nextLength, colOffset + nextLength, nextLength);
    }

    private void solution() throws IOException {

        K = Integer.parseInt(br.readLine());
        int length = 1 << K;

        board = new int[length][length];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;
        board[x][y] = -1;


        blockNum = 0;
        makeBoardTable(0, 0, length);

        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                sb.append(board[i][j]).append(" ");
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
