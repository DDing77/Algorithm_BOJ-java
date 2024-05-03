import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private int N;
    private char[][] originBoard;
    private char[][] resBoard;

    private void printInsertMine() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (originBoard[i][j] == '*') {
                    resBoard[i][j] = '*';
                }
            }
        }
    }

    private int search(int x, int y) {

        int count = 0;
        for (int i = 0; i < dir.length; i++) {
            int nX = x + dir[i][0];
            int nY = y + dir[i][1];

            if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                continue;
            }

            if (originBoard[nX][nY] == '*') {
                count++;
            }
        }
        return count;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        originBoard = new char[N][N];
        for (int i = 0; i < N; i++) {
            originBoard[i] = br.readLine().toCharArray();
        }

        boolean isDead = false;
        resBoard = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char cur = input.charAt(j);
                if (cur == '.') {
                    resBoard[i][j] = '.';
                } else if (cur == 'x') {
                    if (originBoard[i][j] == '*') {
                        resBoard[i][j] = '*';
                        isDead = true;
                    } else {
                        resBoard[i][j] = (char) (search(i, j) + '0');
                    }
                }
            }
        }

        if (isDead) {
            printInsertMine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(resBoard[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
