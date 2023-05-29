import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // BOJ_1992
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }

        QuadTree(N, 0, 0);
        System.out.println(sb);

    }

    static void QuadTree(int len, int row, int col) {
        if (colorCheck(len, row, col)) {
            sb.append(map[row][col]);
            return;
        }

        int newLen = len / 2;
        sb.append('(');
        QuadTree(newLen, row, col);
        QuadTree(newLen, row, col + newLen);
        QuadTree(newLen, row + newLen, col);
        QuadTree(newLen, row + newLen, col + newLen);
        sb.append(')');
    }

    static boolean colorCheck(int len, int row, int col) {
        int color = map[row][col];

        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
