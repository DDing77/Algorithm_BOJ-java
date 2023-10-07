import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    int N;
    int M;
    char[][] board;
    int startX;
    int startY;
    int res;

    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0});
        board[startX][startY] = '#';

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (board[nX][nY] == '#') {
                    continue;
                }

                if (board[nX][nY] == 'X') {
                    res = cur[2] + 1;
                    return;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                board[nX][nY] = '#';
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'K') {
                    startX = i;
                    startY = j;
                }
            }
        }

        res = -1;

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
