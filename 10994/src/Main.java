import java.io.*;
import java.util.*;

public class Main { // B0J_10994
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new char[4 * N - 3][4 * N - 3];
        for (int i = 0; i < 4 * N - 3; i++) {
            Arrays.fill(map[i], ' ');
        }

        dc(N, 0, 0);

        for (int i = 0; i < 4 * N - 3; i++) {
            for (int j = 0; j < 4 * N - 3; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dc(int size, int row, int col) {
        if (size <= 1) {
            map[row][col] = '*';
        } else {
            int len = 4 * size - 3;
            for (int i = row; i < row+len; i++) {
                for (int j = col; j <col+ len; j++) {
                    map[row][j] = '*';
                    map[row + len -1][j] = '*';
                    map[i][col] = '*';
                    map[i][col + len -1] = '*';
                }
            }
            dc(size - 1, row + 2, col + 2);
        }

    }
}
