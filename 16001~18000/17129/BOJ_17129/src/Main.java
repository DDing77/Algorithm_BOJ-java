import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int N;
    int M;
    char[][] board;
    int startX;
    int startY;
    int res;

    public void execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0});
        board[startX][startY] = '1';

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (board[nX][nY] == '1') {
                    continue;
                }

                if (board[nX][nY] == '3' || board[nX][nY] == '4' || board[nX][nY] == '5') {
                    res = cur[2] + 1;
                    return;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                board[nX][nY] = '1';

            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        startX = 0;
        startY = 0;
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == '2') {
                    startX = i;
                    startY = j;
                }
            }
        }

        res = -1;

        execBFS();

        if (res == -1) {
            System.out.println("NIE");
        } else {
            sb.append("TAK").append('\n').append(res);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
