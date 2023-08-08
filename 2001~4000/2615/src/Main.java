import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    final int LENGTH = 19;
    char[][] board;
    int[][][] cnt;
    int[][] dir = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};

    private int getCnt(int x, int y, int d, char color) {
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        if (board[nx][ny] == color) {
            return cnt[nx][ny][d] = getCnt(nx, ny, d, color) + 1;
        }
        return 1;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        board = new char[LENGTH + 2][LENGTH + 2];
        cnt = new int[LENGTH + 2][LENGTH + 2][4];

        for (int i = 1; i <= LENGTH; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= LENGTH; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        boolean isFind = false;
        loop:
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (board[i][j] != '0') {
                    for (int d = 0; d < 4; d++) {
                        if (cnt[i][j][d] == 0 && getCnt(i, j, d, board[i][j]) == 5) {
                            isFind = true;
                            sb.append(board[i][j]).append('\n').append(i + " " + j);
                            break loop;
                        }
                    }
                }
            }
        }

        if (!isFind) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}