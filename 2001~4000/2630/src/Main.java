import java.io.*;
import java.util.*;

public class Main {
    public static int[][] map;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dc(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    static boolean colorCheck(int size, int row, int col) {
        int color = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != color) return false;
            }
        }
        return true;
    }

    static void dc(int size, int row, int col) {
        if(colorCheck(size, row, col)) {
            if(map[row][col] == 0) {
                white++;
            } else blue++;
            return;
        }
        size /= 2;
        dc(size, row, col);
        dc(size, row, col+size);
        dc(size, row+size, col);
        dc(size, row+size, col+size);
    }
}
