import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final HashMap<Character, int[]> table = new HashMap<>();

    private char[][] board = new char[4][4];

    private void initTable() {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) {
                    table.put('.', new int[]{i, j});
                } else {
                    table.put((char) ('A' + cnt), new int[]{i, j});
                }
                cnt++;
            }
        }
    }

    private void solution() throws IOException {
        initTable();

        for (int i = 0; i < 4; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                int[] idx = table.get(c);
                res += (Math.abs(idx[0] - i) + Math.abs(idx[1] - j));
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
