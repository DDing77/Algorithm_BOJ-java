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
    private int[][] itemIdx;
    private int startX;
    private int startY;
    private int itemCnt;
    private int res;

    private int execBFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{startX, startY, 0, 0});
        boolean[][][] isVisited = new boolean[M][N][1 << itemCnt];
        isVisited[startX][startY][0] = true;

        int fullMask = (1 << itemCnt) - 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (board[cur[0]][cur[1]] == 'E' && cur[2] == fullMask) {
                return cur[3];
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= M || nY < 0 || nY >= N) {
                    continue;
                }

                if (board[nX][nY] == '#') {
                    continue;
                }

                int nextMask = cur[2];

                if (board[nX][nY] == 'X') {
                    nextMask |= 1 << itemIdx[nX][nY];
                }

                if (!isVisited[nX][nY][nextMask]) {
                    que.add(new int[]{nX, nY, nextMask, cur[3] + 1});
                    isVisited[nX][nY][nextMask] = true;
                }
            }
        }

        return -1;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[M][N];
        itemIdx = new int[M][N];
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
                itemIdx[i][j] = -1;
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (board[i][j] == 'X') {
                    itemIdx[i][j] = itemCnt++;
                }
            }
        }

        res = execBFS();
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
