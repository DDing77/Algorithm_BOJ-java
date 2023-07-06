import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int[][] dir = {{-1, 0}, {0, -1}};
    static int N;
    static char[][] origin;
    static int res;

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = origin[x1][y1];
        origin[x1][y1] = origin[x2][y2];
        origin[x2][y2] = temp;
    }

    public static int getCnt(int x1, int y1, int x2, int y2) {
        int cnt;

        cnt = 1;
        for (int j = 1; j < N; j++) {
            if (origin[x1][j - 1] == origin[x1][j]) {
                cnt++;
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }

        cnt = 1;
        for (int i = 1; i < N; i++) {
            if (origin[i - 1][y1] == origin[i][y1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }

        cnt = 1;
        for (int j = 1; j < N; j++) {
            if (origin[x2][j - 1] == origin[x2][j]) {
                cnt++;
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }

        cnt = 1;
        for (int i = 1; i < N; i++) {
            if (origin[i - 1][y2] == origin[i][y2]) {
                cnt++;
            } else {
                cnt = 1;
            }
            res = Math.max(res, cnt);
        }

        return res;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        N = Integer.parseInt(br.readLine());
        origin = new char[N][N];
        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    int nX = i + dir[k][0];
                    int nY = j + dir[k][1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }

                    if (origin[i][j] == origin[nX][nY]) {
                        res = getCnt(i, j, nX, nY);
                        continue;
                    }

                    swap(i, j, nX, nY);
                    res = getCnt(i, j, nX, nY);
                    swap(i, j, nX, nY);
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
