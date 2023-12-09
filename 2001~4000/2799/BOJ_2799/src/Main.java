import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final int TYPES = 5;
    int N;
    int M;
    char[][] board;
    int[] res;

    private int searchType(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (board[x + i][y] != '*') {
                break;
            }
            cnt++;
        }
        return cnt;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N * 5 + 1][M * 5 + 1];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine().toCharArray();
        }

        res = new int[TYPES];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[searchType(i * 5 + 1, j * 5 + 1)]++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
