import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[][] board;

    private boolean searchType1(int x, int y) {
        try {
            if (board[x][y] == board[x - 1][y - 1] && board[x][y] == board[x + 1][y + 1]) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean searchType2(int x, int y) {
        try {
            if (board[x][y] == board[x - 1][y + 1] && board[x][y] == board[x + 1][y - 1]) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean searchType3(int x, int y) {
        try {
            if (board[x][y] == board[x][y - 1] && board[x][y] == board[x][y + 1]) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private boolean searchType4(int x, int y) {
        try {
            if (board[x][y] == board[x - 1][y] && board[x][y] == board[x + 1][y]) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N < 3) {
            System.out.println("ongoing");
            return;
        }

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.' && (searchType1(i, j) || searchType2(i, j) || searchType3(i, j) || searchType4(i, j))) {
                    System.out.println(board[i][j]);
                    return;
                }
            }
        }
        System.out.println("ongoing");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
