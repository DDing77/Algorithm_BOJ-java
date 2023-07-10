import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] board;


    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int row = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag)
                row++;
        }

        int col = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag)
                col++;
        }

        System.out.println(Math.max(row, col));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
