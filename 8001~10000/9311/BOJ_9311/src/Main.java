import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int T;
    int R;
    int C;
    char[][] board;
    int startX;
    int startY;
    int res;

    public void execBFS() {
        boolean[][] isVisited = new boolean[R][C];
        isVisited[startX][startY] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (board[cur[0]][cur[1]] == 'G') {
                res = cur[2];
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] == 'X') {
                    continue;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            board = new char[R][C];
            for (int i = 0; i < R; i++) {
                String input = br.readLine();
                for (int j = 0; j < C; j++) {
                    board[i][j] = input.charAt(j);
                    if (board[i][j] == 'S') {
                        startX = i;
                        startY = j;
                    }
                }
            }

            res = 0;

            execBFS();

            if (res == 0) {
                sb.append("No Exit");
            } else {
                sb.append("Shortest Path: ").append(res);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
