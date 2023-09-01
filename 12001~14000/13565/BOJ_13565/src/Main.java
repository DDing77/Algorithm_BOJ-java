import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int M;
    int N;
    char[][] board;
    boolean[][] isVisited;
    Queue<int[]> que;

    public void execBFS() {
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nY < 0 || nY >= N) {
                    continue;
                }

                if (nX >= M) {
                    System.out.println("YES");
                    return;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == '1') {
                    continue;
                }

                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY});
            }
        }
        System.out.println("NO");
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[M][N];
        for (int i = 0; i < M; i++) {
            board[i] = br.readLine().toCharArray();
        }

        isVisited = new boolean[M][N];
        que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (board[0][i] == '0') {
                que.add(new int[]{0, i});
                isVisited[0][i] = true;
            }
        }

        execBFS();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
