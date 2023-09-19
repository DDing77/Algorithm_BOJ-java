import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{0, 1}, {1, 0}};
    int N;
    int M;
    int[][] board;
    int res;

    public void execBFS() {
        boolean[][] isVisited = new boolean[N][M];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                res = cur[2];
                break;
            }

            for (int k = 0; k < dir.length; k++) {
                for (int i = 1; i <= board[cur[0]][cur[1]]; i++) {
                    int nX = cur[0] + dir[k][0] * i;
                    int nY = cur[1] + dir[k][1] * i;

                    if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                        continue;
                    }

                    if (isVisited[nX][nY]) {
                        continue;
                    }

                    isVisited[nX][nY] = true;
                    que.add(new int[]{nX, nY, cur[2] + 1});
//                    System.out.println("nX = " + nX + " , nY = " + nY + " , cnt = " + (cur[2] + 1));
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
