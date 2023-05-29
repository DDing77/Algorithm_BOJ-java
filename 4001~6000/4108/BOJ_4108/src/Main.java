import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private final int[][] dir = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    private int R, C;
    private char[][] landMines;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (R == 0 && C == 0) {
                break;
            }

            landMines = new char[R][C];
            for (int i = 0; i < R; i++) {
                landMines[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    char ch = landMines[i][j];
                    if (ch == '.') {
                        int cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            int nX = i + dir[k][0];
                            int nY = j + dir[k][1];

                            if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                                continue;
                            }
                            if (landMines[nX][nY] == '*') {
                                cnt++;
                            }
                        }
                        sb.append(cnt);
                    } else {
                        sb.append("*");
                    }
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
