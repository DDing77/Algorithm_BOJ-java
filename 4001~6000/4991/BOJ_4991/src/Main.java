import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private char[][] board;
    private int startX;
    private int startY;
    private int[][] dirtyIdx;
    private int dirtyCnt;
    private int res;

    private int execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0, 0});

        boolean[][][] isVisited = new boolean[M][N][1 << dirtyCnt];
        isVisited[startX][startY][0] = true;

        int fullMask = (1 << dirtyCnt) - 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[2] == fullMask) {
                return cur[3];
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= M || nY < 0 || nY >= N) {
                    continue;
                }

                if (board[nX][nY] == 'x') {
                    continue;
                }

                int nextMask = cur[2];

                if (board[nX][nY] == '*') {
                    nextMask |= 1 << dirtyIdx[nX][nY];
                }

                if (!isVisited[nX][nY][nextMask]) {
                    isVisited[nX][nY][nextMask] = true;
                    que.add(new int[]{nX, nY, nextMask, cur[3] + 1});
                }
            }
        }

        return -1;
    }

    private void solution() throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            board = new char[M][N];
            dirtyIdx = new int[M][N];
            dirtyCnt = 0;
            for (int i = 0; i < M; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = input.charAt(j);
                    dirtyIdx[i][j] = -1;

                    if (board[i][j] == 'o') {
                        startX = i;
                        startY = j;
                    } else if (board[i][j] == '*') {
                        dirtyIdx[i][j] = dirtyCnt++;
                    }
                }
            }

            sb.append(execBFS()).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
