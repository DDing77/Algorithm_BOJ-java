import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int SIZE = 5;
    private static final int GOAL = 7;
    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private char[][] board;
    private boolean[] isVisited;
    private int[] selected;
    private int res;

    private void comb(int idx, int depth, int sCnt, int yCnt) {

        if (yCnt > GOAL / 2) {
            return;
        }

        if (depth == GOAL) {
            if (execBFS()) {
                res++;
            }
            return;
        }

        for (int i = idx; i < SIZE * SIZE; i++) {
            selected[depth] = i;
            int next_sCnt = sCnt;
            int next_yCnt = yCnt;
            if (board[i / SIZE][i % SIZE] == 'S') {
                next_sCnt++;
            } else {
                next_yCnt++;
            }

            comb(i + 1, depth + 1, next_sCnt, next_yCnt);
        }
    }

    private boolean execBFS() {

        isVisited = new boolean[7];
        isVisited[0] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{selected[0] / SIZE, selected[0] % SIZE});
        int cnt = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];
                int nIdx = nX * SIZE + nY;

                if (nX < 0 || nX >= SIZE || nY < 0 || nY >= SIZE) {
                    continue;
                }

                for (int j = 0; j < isVisited.length; j++) {
                    if (isVisited[j]) {
                        continue;
                    }
                    if (selected[j] != nIdx) {
                        continue;
                    }

                    cnt++;
                    que.add(new int[]{nX, nY});
                    isVisited[j] = true;
                }
            }
        }

        return cnt == 7;
    }

    private void solution() throws IOException {

        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            board[i] = br.readLine().toCharArray();
        }

        selected = new int[GOAL];
        comb(0, 0, 0, 0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
