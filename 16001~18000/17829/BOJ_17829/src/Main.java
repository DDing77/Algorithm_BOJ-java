import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[][] board;
    int res;
    List<Integer> temp;

    private int dq(int length, int row, int col) {

        if (length == 2) {
            temp = new ArrayList<>();
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    temp.add(board[i][j]);
                }
            }

            Collections.sort(temp);

            return temp.get(2);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(dq(length / 2, row, col));
        temp.add(dq(length / 2, row, col + length / 2));
        temp.add(dq(length / 2, row + length / 2, col));
        temp.add(dq(length / 2, row + length / 2, col + length / 2));

        Collections.sort(temp);

        return temp.get(2);
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

        res = dq(N, 0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
