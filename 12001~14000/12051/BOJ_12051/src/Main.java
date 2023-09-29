import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int T;
    int R;
    int C;
    int N;
    char[][] board;
    boolean[][] isVisited;
    char op;
    int res;

    public void execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == '0') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("Case #").append(tc).append(":").append('\n');

            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            board = new char[R][C];
            for (int i = 0; i < R; i++) {
                board[i] = br.readLine().toCharArray();
            }

            N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                op = st.nextToken().charAt(0);

                if (op == 'Q') {
                    res = 0;
                    isVisited = new boolean[R][C];
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (board[i][j] == '1' && !isVisited[i][j]) {
                                res++;
                                execBFS(i, j);
                            }
                        }
                    }
                    sb.append(res).append('\n');
                } else {
                    board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
                }
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
