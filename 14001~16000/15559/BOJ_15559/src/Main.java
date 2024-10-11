import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private char[][] board;
    private int[] parents;
    private int res;

    private int find(int idx) {

        if (parents[idx] < 0) {
            return idx;
        }
        return parents[idx] = find(parents[idx]);
    }

    private boolean union(int idx1, int idx2) {

        int a = find(idx1);
        int b = find(idx2);

        if (a == b) {
            return false;
        }

        if (parents[a] <= parents[b]) {
            parents[a] += parents[b];
            parents[b] = a;
        } else {
            parents[b] += parents[a];
            parents[a] = b;
        }

        return true;
    }

    private void execDFS(int idx, int x, int y, char cur) {

        int nX = x;
        int nY = y;
        if (cur == 'N') {
            nX -= 1;
        } else if (cur == 'S') {
            nX += 1;
        } else if (cur == 'W') {
            nY -= 1;
        } else {
            nY += 1;
        }

        int nextIdx = nX * M + nY;
        if (!union(idx, nextIdx)) {
            return;
        } else {
            execDFS(nextIdx, nX, nY, board[nX][nY]);
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        parents = new int[N * M];
        Arrays.fill(parents, -1);

        for (int i = 0; i < N * M; i++) {
            if (parents[i] == -1) {
                int x = i / M;
                int y = i % M;
                execDFS(i, x, y, board[x][y]);
            }
        }

        for (int i = 0; i < N * M; i++) {
            if (parents[i] < 0) {
                res++;
            }
        }

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
