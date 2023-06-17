import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;
    static int sumW;
    static int sumB;
    static char[][] board;
    static boolean[][] isVisited;

    public static int execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        int cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] != board[x][y]) {
                    continue;
                }

                cnt++;
                isVisited[nX][nY] = true;
                que.add(new int[]{nX, nY});
            }
        }

        return cnt;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        sumW = 0;
        sumB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    if (board[i][j] == 'W') {
                        sumW += Math.pow(execBFS(i, j), 2);
                    } else {
                        sumB += Math.pow(execBFS(i, j), 2);
                    }
                }
            }
        }

        System.out.println(sumW + " " + sumB);
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
