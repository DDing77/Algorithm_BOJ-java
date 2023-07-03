import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int R;
    static int C;
    static int[][] board;
    static boolean[][] isVisited;
    static int res;
    static int waterSetCnt;
    static int[] parent;
    static Queue<int[]> ices;
    static Queue<int[]> waters;
    static int[][] swan;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return false;
        }

        if (a <= b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

        return true;
    }

    public static void bfs(int x, int y) {
        waters = new ArrayDeque<>();
        waters.add(new int[]{x, y});

        while (!waters.isEmpty()) {
            int[] cur = waters.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur[0] + dir[k][0];
                int nY = cur[1] + dir[k][1];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == -1) {
                    ices.add(new int[]{nX, nY, waterSetCnt});
                    isVisited[nX][nY] = true;
                    continue;
                }

                if (board[nX][nY] == 0) {
                    isVisited[nX][nY] = true;
                    board[nX][nY] = waterSetCnt;
                    waters.add(new int[]{nX, nY});
                }
            }
        }
    }

    public static void getDay() {
        while (!ices.isEmpty()) {
            res++;
            int icesSize = ices.size();

            for (int i = 0; i < icesSize; i++) {
                int[] cur = ices.poll();
                board[cur[0]][cur[1]] = cur[2];

                for (int k = 0; k < 4; k++) {
                    int nX = cur[0] + dir[k][0];
                    int nY = cur[1] + dir[k][1];
                    if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                        continue;
                    }

                    if (isVisited[nX][nY] && board[nX][nY] != -1) {
                        if (find(cur[2]) != find(board[nX][nY])) {
                            union(cur[2], board[nX][nY]);
                        }
                    }

                    if (!isVisited[nX][nY]) {
                        isVisited[nX][nY] = true;
                        ices.add(new int[]{nX, nY, cur[2]});
                    }
                }
            }
            if (find(board[swan[0][0]][swan[0][1]]) == find(board[swan[1][0]][swan[1][1]])) {
                return;
            }
        }

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        swan = new int[2][2];
        int swanCnt = 0;
        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char cur = input.charAt(j);
                if (cur == 'L') {
                    swan[swanCnt][0] = i;
                    swan[swanCnt][1] = j;
                    swanCnt++;
                }
                if (cur == 'X') {
                    board[i][j] = -1;
                }
            }
        }

        ices = new ArrayDeque<>();

        waterSetCnt = 0;
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisited[i][j] && board[i][j] == 0) {
                    isVisited[i][j] = true;
                    waterSetCnt++;
                    board[i][j] = waterSetCnt;
                    bfs(i, j);
                }
            }
        }

        parent = new int[waterSetCnt + 1];
        for (int i = 0; i <= waterSetCnt; i++) {
            parent[i] = i;
        }

        if (find(board[swan[0][0]][swan[0][1]]) == find(board[swan[1][0]][swan[1][1]])) {
            System.out.println(0);
            return;
        }

        res = 0;
        getDay();

        System.out.println(res);
//
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(board[i]));
//        }
//
//        for (int i = 0; i < 2; i++) {
//            System.out.println(Arrays.toString(swan[i]));
//        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
