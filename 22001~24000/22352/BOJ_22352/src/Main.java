import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private int[][] before;
    private int[][] after;
    private boolean[][] isVisited;
    private boolean check;

    private boolean execBFS(int x, int y) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] next : dir) {
                int nX = next[0] + cur[0];
                int nY = next[1] + cur[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (before[x][y] == before[nX][nY]) {
                    if (after[x][y] == after[nX][nY]) {
                        que.add(new int[]{nX, nY});
                        isVisited[nX][nY] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void initTable(int[][] board) throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        before = new int[N][M];
        initTable(before);

        after = new int[N][M];
        initTable(after);

        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    if (before[i][j] == after[i][j]) {
                        if (!execBFS(i, j)) {
                            System.out.println("NO");
                            return;
                        }
                    } else {
                        if (check) {
                            System.out.println("NO");
                            return;
                        }
                        if (!execBFS(i, j)) {
                            System.out.println("NO");
                            return;
                        }
                        check = true;
                    }
                }
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
