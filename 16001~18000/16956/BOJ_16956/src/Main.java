import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int M;
    char[][] board;
    boolean check;
    Queue<int[]> que;

    private void execBFS() {

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (board[nX][nY] == 'S') {
                    check = false;
                    return;
                }

                if (board[nX][nY] == '.') {
                    board[nX][nY] = 'D';
                }
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'W') {
                    que.add(new int[]{i, j});
                }
            }
        }

        check = true;
        execBFS();

        if (!check) {
            System.out.println(0);
        } else {
            sb.append("1").append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
