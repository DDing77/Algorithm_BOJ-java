import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[][][] board;
    private int minCount;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N][5][7];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = br.readLine().toCharArray();
            }
        }

        minCount = Integer.MAX_VALUE;
        int a = -1;
        int b = -1;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int count = 0;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 7; l++) {
                        if (board[i][k][l] != board[j][k][l]) {
                            count++;
                        }
                    }
                }
                if (count < minCount) {
                    a = i + 1;
                    b = j + 1;
                    minCount = count;
                }
            }
        }

        sb.append(a).append(" ").append(b);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
