import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String[][] board;

    private void solution() throws IOException {

        board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = st.nextToken();
            }
        }


        for (int i = 0; i < 10; i++) {
            boolean check = true;
            for (int j = 1; j < 10; j++) {
                if (!board[i][j - 1].equals(board[i][j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < 10; i++) {
            boolean check = true;
            for (int j = 1; j < 10; j++) {
                if (!board[j - 1][i].equals(board[j][i])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
