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

    public void execBFS(int x, int y) {
        boolean[][] isVisited = new boolean[N][M];
        isVisited[x][y] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});

        res = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] != '.') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
                res++;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0) {
                break;
            }

            board = new char[N][M];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = input.charAt(j);
                    if (board[i][j] == '@') {
                        startX = i;
                        startY = j;
                    }
                }
            }

            execBFS(startX, startY);

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
