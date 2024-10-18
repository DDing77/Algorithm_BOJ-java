import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    private int N;
    private int M;
    private int[][] board;
    private int[] parents;
    private int[] res;

    private int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        parents = new int[N * M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int y = i;
                int x = j;
                for (int k = 0; k < 8; k++) {
                    int nY = i + dy[k];
                    int nX = j + dx[k];

                    if (nY < 0 || nY >= N || nX < 0 || nX >= M) {
                        continue;
                    }

                    if (board[y][x] > board[nY][nX]) {
                        y = nY;
                        x = nX;
                    }
                }
                parents[i * M + j] = y * M + x;
            }
        }

        res = new int[N * M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[find(i * M + j)]++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(res[i * M + j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
