import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private int T;
    private int[][] board;
    private boolean[][] isVisited;

    private int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    private double getAvg() {
        int cnt = 0;
        double sum = 0.;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    cnt++;
                    sum += board[i][j];
                }
            }
        }
        return sum / cnt;
    }

    private void changeValueWithAvg(double avg) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if ((double) board[i][j] > avg) {
                    board[i][j]--;
                } else if ((double) board[i][j] < avg) {
                    board[i][j]++;
                }
            }
        }
    }

    private boolean execBFS(int boardIdx, int valueIdx) {
        int targetValue = board[boardIdx][valueIdx];
        boolean isFind = false;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{boardIdx, valueIdx});
        isVisited[boardIdx][valueIdx] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();


            for (int[] dir : dirs) {
                int nextBoardIdx = cur[0] + dir[0];
                int nextValueIdx = cur[1] + dir[1];

                if (nextBoardIdx < 0 || nextBoardIdx >= N) {
                    continue;
                }

                if (nextValueIdx < 0) {
                    nextValueIdx = M - 1;
                } else if (nextValueIdx >= M) {
                    nextValueIdx = 0;
                }

                if (isVisited[nextBoardIdx][nextValueIdx]) {
                    continue;
                }
                if (board[nextBoardIdx][nextValueIdx] != targetValue) {
                    continue;
                }

                isVisited[nextBoardIdx][nextValueIdx] = true;
                isFind = true;
                board[nextBoardIdx][nextValueIdx] = 0;
                que.add(new int[]{nextBoardIdx, nextValueIdx});
            }
        }

        if (isFind) {
            board[boardIdx][valueIdx] = 0;
        }
        return isFind;
    }

    private void rotateRight(int boardIdx, int k) {
        Deque<Integer> que = new ArrayDeque<>();
        for (int value : board[boardIdx]) {
            que.add(value);
        }

        for (int i = 0; i < k; i++) {
            int temp = que.pollLast();
            que.addFirst(temp);
        }

        int idx = 0;
        while (!que.isEmpty()) {
            board[boardIdx][idx++] = que.pollFirst();
        }
    }

    private void rotateLeft(int boardIdx, int k) {
        Deque<Integer> que = new ArrayDeque<>();
        for (int value : board[boardIdx]) {
            que.add(value);
        }

        for (int i = 0; i < k; i++) {
            int temp = que.pollFirst();
            que.addLast(temp);
        }

        int idx = 0;
        while (!que.isEmpty()) {
            board[boardIdx][idx++] = que.pollFirst();
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                if (i % x == 0) {
                    if (d == 0) { //시계 방향
                        rotateRight(i - 1, k);
                    } else if (d == 1) {// 반시계 방향
                        rotateLeft(i - 1, k);
                    }
                }
            }

            isVisited = new boolean[N][M];
            boolean isFind = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!isVisited[i][j] && board[i][j] != 0) {
                        isFind |= execBFS(i, j);
                    }
                }
            }

            if (!isFind) {
                double avg = getAvg();
                changeValueWithAvg(avg);
            }
        }

        int res = getSum();
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
