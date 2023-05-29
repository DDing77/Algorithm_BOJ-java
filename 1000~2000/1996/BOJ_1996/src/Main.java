import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static int N;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        res = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char cur = input[j];
                if (cur != '.') {
                    res[i][j] = -1;
                    for (int k = 0; k < 8; k++) {
                        int nX = i + dir[k][0];
                        int nY = j + dir[k][1];
                        if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
                        if (res[nX][nY] == -1) continue;
                        res[nX][nY] += cur - '0';
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (res[i][j] == -1) sb.append('*');
                else if (res[i][j] >= 10) sb.append('M');
                else sb.append(res[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
