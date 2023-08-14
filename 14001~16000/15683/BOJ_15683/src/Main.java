import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final int[][][] mode = {
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}
    };
    char[][] board;
    int R;
    int C;
    ArrayList<CCTV> cctvs;
    int res;

    public int getCnt(char[][] board) {
        int cnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '0') {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void execDFS(char[][] temp, int depth) {
        if (depth == cctvs.size()) {
            res = Math.min(res, getCnt(temp));
            return;
        }


        int x = cctvs.get(depth).x;
        int y = cctvs.get(depth).y;
        int type = cctvs.get(depth).type - 1;
        char[][] copy;

        for (int i = 0; i < mode[type].length; i++) {
            copy = new char[R][C];
            for (int j = 0; j < R; j++) {
                copy[j] = temp[j].clone();
            }

            for (int j = 0; j < mode[type][i].length; j++) {
                int direction = mode[type][i][j];
                int nX = x + dir[direction][0];
                int nY = y + dir[direction][1];

                while (true) {
                    if (nX < 0 || nX >= R || nY < 0 || nY >= C) {
                        break;
                    }

                    if (copy[nX][nY] == '6') {
                        break;
                    }

                    copy[nX][nY] = '#';
                    nX += dir[direction][0];
                    nY += dir[direction][1];
                }
            }

            execDFS(copy, depth + 1);
        }
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        res = 0;
        cctvs = new ArrayList<>();

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == '0') {
                    res++;
                } else if ('1' <= board[i][j] && board[i][j] <= '5') {
                    cctvs.add(new CCTV(i, j, board[i][j] - '0'));
                }
            }
        }

        execDFS(board, 0);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static class CCTV {
        int x;
        int y;
        int type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
