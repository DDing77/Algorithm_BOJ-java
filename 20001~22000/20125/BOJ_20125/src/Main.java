import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private char[][] board;
    private int heartX;
    private int heartY;

    private void findHeart() {
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (board[i][j] == '*' && board[i - 1][j] == '*' && board[i + 1][j] == '*' && board[i][j - 1] == '*' && board[i + 1][j] == '*') {
                    heartX = i;
                    heartY = j;
                    return;
                }
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        findHeart();

        int leftArm = 0;
        for (int i = heartY - 1; i >= 0; i--) {
            if (board[heartX][i] == '*') {
                leftArm++;
            } else {
                break;
            }
        }

        int rightArm = 0;
        for (int i = heartY + 1; i < N; i++) {
            if (board[heartX][i] == '*') {
                rightArm++;
            } else {
                break;
            }
        }

        int body = 0;
        int bodyEndX = -1;
        for (int i = heartX + 1; i < N; i++) {
            if (board[i][heartY] == '*') {
                body++;
                bodyEndX = i;
            } else {
                break;
            }
        }

        int leftLeg = 0;
        for (int i = bodyEndX + 1; i < N; i++) {
            if (board[i][heartY - 1] == '*') {
                leftLeg++;
            } else {
                break;
            }
        }

        int rightLeg = 0;
        for (int i = bodyEndX + 1; i < N; i++) {
            if (board[i][heartY + 1] == '*') {
                rightLeg++;
            } else {
                break;
            }
        }
        sb.append(heartX + 1).append(" ").append(heartY + 1).append('\n');
        sb.append(leftArm).append(" ").append(rightArm).append(" ").
                append(body).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
