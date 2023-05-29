import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] ans; // -1 : [0], 0 : [1], 1 : [2]
    static int[][] map;

    static boolean isSame(int row, int col, int len) {
        int pre = map[row][col];
        int cur;
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                cur = map[i][j];
                if (pre != cur) return false;
                pre = cur;
            }
        }
        return true;
    }

    static void divide_conquer(int row, int col, int len) {
        if (isSame(row, col, len)) {
            int number = map[row][col];
            if( number == -1) number =2;
            ans[number] += 1;
            return;
        }
            int newLen = len / 3;
            divide_conquer(row, col, newLen);
            divide_conquer(row, col + newLen, newLen);
            divide_conquer(row, col + newLen * 2, newLen);
            divide_conquer(row + newLen, col, newLen);
            divide_conquer(row + newLen, col + newLen, newLen);
            divide_conquer(row + newLen, col + newLen * 2, newLen);
            divide_conquer(row + newLen * 2, col, newLen);
            divide_conquer(row + newLen * 2, col + newLen, newLen);
            divide_conquer(row + newLen * 2, col + newLen * 2, newLen);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        ans = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide_conquer(0, 0, N);
        sb.append(ans[2]).append('\n');
        sb.append(ans[0]).append('\n');
        sb.append(ans[1]).append('\n');
        System.out.println(sb);
    }
}
