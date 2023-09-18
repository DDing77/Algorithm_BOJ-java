import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int MAX = 26;
    int N;
    int M;
    boolean[][] board;
    String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        board = new boolean[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (i == j) {
                    board[i][j] = true;
                }
            }
        }

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            board[input.charAt(0) - 'a'][input.charAt(input.length() - 1) - 'a'] = true;
        }

        for (int k = 0; k < MAX; k++) {
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    if (board[i][k] && board[k][j]) {
                        board[i][j] = true;
                    }
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            input = br.readLine();

            if (board[input.charAt(0) - 'a'][input.charAt(input.length() - 1) - 'a']) {
                sb.append("T");
            } else {
                sb.append("F");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
