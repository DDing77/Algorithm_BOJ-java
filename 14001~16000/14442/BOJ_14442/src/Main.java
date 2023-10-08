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
    char[][] board;
    boolean[][][] isVisited;
    int res;

    public void execBFS() {
        isVisited = new boolean[N][M][K + 1];
        isVisited[0][0][0] = true;
        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(0, 0, 0, 1));

        while (!que.isEmpty()) {
            Pos cur = que.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                res = cur.moveCnt;
                return;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur.x + dir[i][0];
                int nY = cur.y + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (board[nX][nY] == '0' && !isVisited[nX][nY][cur.wallCnt]) {
                    isVisited[nX][nY][cur.wallCnt] = true;
                    que.add(new Pos(nX, nY, cur.wallCnt, cur.moveCnt + 1));
                } else if (board[nX][nY] == '1' && cur.wallCnt + 1 <= K && !isVisited[nX][nY][cur.wallCnt + 1]) {
                    isVisited[nX][nY][cur.wallCnt + 1] = true;
                    que.add(new Pos(nX, nY, cur.wallCnt + 1, cur.moveCnt + 1));
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        res = -1;

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Pos {
        int x;
        int y;
        int wallCnt;
        int moveCnt;

        public Pos(int x, int y, int wallCnt, int moveCnt) {
            this.x = x;
            this.y = y;
            this.wallCnt = wallCnt;
            this.moveCnt = moveCnt;
        }
    }
}
