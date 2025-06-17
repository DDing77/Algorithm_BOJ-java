import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int R;
    private int C;
    private char[][] board;
    private int[] res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = new int[5];
        for (int i = 0; i < R - 1; i++) {
            for (int j = 0; j < C - 1; j++) {
                int xCount = 0;
                boolean flag = false;
                loop: for (int k = i; k < i + 2; k++) {
                    for (int l = j; l < j + 2; l++) {
                        if (board[k][l] == 'X') {
                            xCount++;
                        } else if (board[k][l] == '#') {
                            flag = true;
                            break loop;
                        }
                    }
                }

                if (!flag) {
                    res[xCount]++;
                }
            }
        }

        for (int count : res) {
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
