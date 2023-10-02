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
    int K;
    int[][] board;
    int require;

    public int execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        board[x][y] = 1;

        int cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (board[nX][nY] == 1) {
                    continue;
                }

                que.add(new int[]{nX, nY});
                cnt++;
                board[nX][nY] = 1;
            }
        }

        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        require = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    int cnt = execBFS(i, j);
                    require += cnt / K;
                    if (cnt % K != 0) {
                        require++;
                    }
                }

                if (require > M) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }
        if (require == 0) {
            sb.append("IMPOSSIBLE");
        } else {
            sb.append("POSSIBLE").append('\n');
            sb.append(M - require);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
