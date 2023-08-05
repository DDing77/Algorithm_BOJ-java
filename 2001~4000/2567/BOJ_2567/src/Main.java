import java.beans.beancontext.BeanContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final int SIZE = 102;
    int N;
    int[][] board;
    int res;

    public void fillBoard(int x, int y) {
        for (int i = x; i < x + 10; i++) {
            for (int j = y; j < y + 10; j++) {
                board[i][j] = 1;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[SIZE][SIZE];

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            fillBoard(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        res = 0;
        for (int i = 1; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nX = i + dir[k][0];
                        int nY = j + dir[k][1];
                        if (board[nX][nY] == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
