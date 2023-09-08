import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int R;
    int C;
    int remainWolf;
    int remainSheep;
    char[][] board;
    boolean[][] isVisited;

    public int[] execBFS(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        int sheepCnt = 0;
        int wolfCnt = 0;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (board[cur[0]][cur[1]] == 'k') {
                sheepCnt++;
            } else if (board[cur[0]][cur[1]] == 'v') {
                wolfCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == '#') {
                    continue;
                }

                que.add(new int[]{nX, nY});
                isVisited[nX][nY] = true;
            }
        }

        return new int[]{sheepCnt, wolfCnt};
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        remainSheep = 0;
        remainWolf = 0;
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != '#' && !isVisited[i][j]) {
                    int[] res = execBFS(i, j);
                    if (res[0] > res[1]) {
                        remainSheep += res[0];
                    } else {
                        remainWolf += res[1];
                    }
                }
            }
        }

        sb.append(remainSheep).append(" ").append(remainWolf);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
