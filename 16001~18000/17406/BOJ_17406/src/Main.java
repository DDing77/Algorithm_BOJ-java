import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private int[][] originBoard;
    private List<Query> queries = new ArrayList<>();
    private boolean[] isVisited;
    private int[] order;
    private int resMin;

    private int[][] rotateBoard(int[][] board) {
        for (int queryIdx : order) {
            Query query = queries.get(queryIdx);

            int r = query.r;
            int c = query.c;
            int s = query.s;

            for (int i = s; i >= 1; i--) {
                int topRightTemp = board[r - i][c + i];
                for (int y = c + i; y > c - i; y--) {
                    board[r - i][y] = board[r - i][y - 1];
                }

                int bottomRightTemp = board[r + i][c + i];
                for (int x = r + i; x > r - i; x--) {
                    board[x][c + i] = board[x - 1][c + i];
                }
                board[r - i + 1][c + i] = topRightTemp;

                int bottomLeftTemp = board[r + i][c - i];
                for (int y = c - i; y < c + i; y++) {
                    board[r + i][y] = board[r + i][y + 1];
                }
                board[r + i][c + i - 1] = bottomRightTemp;

                for (int x = r - i; x < r + i; x++) {
                    board[x][c - i] = board[x + 1][c - i];
                }
                board[r + i - 1][c - i] = bottomLeftTemp;
            }
        }

        return board;
    }

    private int getRowSumMin(int[][] board) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += board[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private int[][] copyBoard() {
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = originBoard[i][j];
            }
        }
        return board;
    }

    private void backTracking(int idx) {
        if (idx == K) {
            int[][] copiedBoard = copyBoard();
            copiedBoard = rotateBoard(copiedBoard);
            int queryRes = getRowSumMin(copiedBoard);
            resMin = Math.min(resMin, queryRes);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                order[idx] = i;
                backTracking(idx + 1);
                isVisited[i] = false;
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        originBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            queries.add(new Query(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        isVisited = new boolean[K];
        order = new int[K];
        resMin = Integer.MAX_VALUE;
        backTracking(0);

        System.out.println(resMin);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Query {

        int r;
        int c;
        int s;

        public Query(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
