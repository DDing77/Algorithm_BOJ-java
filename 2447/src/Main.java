import java.io.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                map[i][j] = '*';
//            }
//        }

        dc(false, N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dc(boolean blank, int size, int row, int col) {
        if (blank) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }
        if(size==1) {
            map[row][col]= '*';
            return;
        }

        int newSize = size / 3;
        int count = 0;
        for (int i = row; i < row + size; i += newSize) {
            for (int j = col; j < col + size; j += newSize) {
                count++;
                if (count == 5) {
                    dc(true, newSize, i, j);
                } else dc(false, newSize, i, j);
            }
        }
    }
}
